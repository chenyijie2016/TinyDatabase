/**
 * B+ Tree
 * If you understand B+ or B Tree better, M & N don't need to be the same
 * Here is an example of M=N=4, with 12 keys
 * 5
 * /             \
 * 3                           7             9
 * /         \                  /          |           \
 * 1   2         3    4        5    6       7    8         9   10  11  12
 *
 * @author jwang01
 * @version 1.0.0 created on May 19, 2006
 * edited by Spoon! 2008
 * edited by Mistro 2010
 * @version 2.0.0
 * edited by cyj 2019
 */


package index;

import data.typedData;
import data.typedDataFactor;
import data.intData;
import data.Type;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.*;

public class BPlusTree {
    /**
     * Pointer to the root node. It may be a leaf or an inner node, but it is never null.
     */
    private long root;
    /**
     * the maximum number of keys in the leaf node, M must be > 0
     */
    private int M;
    /**
     * the maximum number of keys in inner node, the number of pointer is N+1, N must be > 2
     */
    private int N;

    private Type keyType;

    private RandomAccessFile treeFile;
    private final NodeFactor nodeFactor = new NodeFactor();

    private static final short INNER = 0;
    private static final short LEAF = 1;
    private Map<Long, Node> NodeCache;


    /**
     * LRU策略的缓存
     * from:https://stackoverflow.com/questions/11469045/how-to-limit-the-maximum-size-of-a-map-by-removing-oldest-entries-when-limit-rea
     *
     * @param maxEntries 最大缓存数量
     */
    public static <K, V> Map<K, V> createLRUMap(final int maxEntries) {
        return new LinkedHashMap<K, V>(maxEntries * 10 / 7, 0.7f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxEntries;
            }
        };
    }

    /**
     * Create a new empty tree.
     */
    public BPlusTree(Type type, String filename) throws IOException {
        this(4, 4, type, filename, 1024);
    }

    public BPlusTree(int m, int n, Type type, String filename, int MAX_CACHE_SIZE) throws IOException {
        M = m;
        N = n;
        NodeCache = createLRUMap(MAX_CACHE_SIZE);

        treeFile = new RandomAccessFile(filename, "rw");
        this.keyType = type;
        if (treeFile.length() > 0) {
            readHeader(); // 文件已存在
        } else {  // 文件不存在，创建根节点
            writeHeader();
            root = -1L;
            Node _root = new LNode();
            _root.saveToFile();
            root = _root.offset;
            writeHeader();
        }

    }

    /**
     * 插入key
     *
     * @param key   插入的key
     * @param value 存储值
     */
    public void insert(typedData key, long value) throws IOException {

        Node __root = nodeFactor.getNode(root);
        Split result = __root.insert(key, value);
        if (result != null) {
            // root节点出现分裂，需要新插入一个InnerNode,并且更新root节点位置为新的InnerNode
            // The old root was split into two parts.
            // We have to create a new root pointing to them

            INode _root = new INode();
            _root.num = 1;
            _root.keys.add(result.key);
            _root.children[0] = result.left;
            _root.children[1] = result.right;
            _root.saveToFile();
            root = _root.offset;
            writeHeader();
        }
        __root.sync();
    }

    /**
     * @return 获取最左侧的叶子节点
     * @throws IOException
     */
    private LNode getLeftMostLeaf() throws IOException {
        Node node = nodeFactor.getNode(root);
        while (node instanceof BPlusTree.INode) {
            INode inner = (INode) node;
            node = nodeFactor.getNode(inner.children[0]);
        }
        return (LNode) node;
    }

    /**
     * @return 获取该B+树的所有叶子节点 value 的迭代器
     * @throws IOException
     */
    public BPlusTreeIterator scanAll() throws IOException {
        LNode node = getLeftMostLeaf();
        return new BPlusTreeIterator(node, node.scanAll());
    }

    /**
     * @param key 待查询的key
     * @return 键值大于等于key的所有value组成的迭代器
     * @throws IOException
     */
    public BPlusTreeIterator scanGreaterEqual(typedData key) throws IOException {
        LNode node = getLNodeByKey(key);
        return new BPlusTreeIterator(node, node.scanGreaterEqual(key));
    }

    /**
     * 写入文件头
     *
     * @throws IOException
     */
    private void writeHeader() throws IOException {
        treeFile.seek(0);
        treeFile.writeInt(M);
        treeFile.writeInt(N);
        treeFile.writeLong(root);
    }

    /**
     * 读取文件头
     *
     * @throws IOException
     */
    private void readHeader() throws IOException {
        treeFile.seek(0);
        M = treeFile.readInt();
        N = treeFile.readInt();
        root = treeFile.readLong();
    }

    /**
     * Looks for the given key. If it is not found, it returns null.
     * If it is found, it returns the associated value.
     */
    public Long scanEqual(typedData key) throws IOException {

        LNode leaf = getLNodeByKey(key);
        int idx = leaf.getLoc(key);
        if (idx < leaf.num && leaf.keys.get(idx).equals(key)) {
            return leaf.values.get(idx);
        } else {
            return null;
        }
    }

    /**
     * @param key 待删除的key
     * @return 删除key所在的节点
     * @throws IOException
     */
    public boolean remove(typedData key) throws IOException {
        LNode leaf = getLNodeByKey(key);
        return leaf.remove(key);
    }

    /**
     * 根据key值获取其可能所在的叶子节点
     *
     * @param key 待查询的key
     * @return 叶子节点
     * @throws IOException
     */
    private LNode getLNodeByKey(typedData key) throws IOException {

        // 循环结束后到达叶子节点
        Node node = nodeFactor.getNode(root);
        while (node instanceof BPlusTree.INode) {
            INode inner = (INode) node;
            int idx = inner.getLoc(key);
            node = nodeFactor.getNode(inner.children[idx]);
        }
        return (LNode) node;
    }


    /**
     * 用来遍历B+树的迭代器
     *
     * @author cyj 2019
     */
    public class BPlusTreeIterator implements Iterator<Long> {
        protected LNode leaf;
        protected Iterator<Long> iter;

        public BPlusTreeIterator(LNode leaf, Iterator<Long> iter) throws IOException {
            this.leaf = leaf;
            this.iter = iter;

            if (!this.iter.hasNext()) {
                advance();
            }
        }

        /**
         * 如果当前的叶子节点上的值已经遍历完了，那么就尝试遍历其指向的下一个节点
         *
         * @throws IOException
         */
        public void advance() throws IOException {
            if (this.leaf.next != -1L) {
                this.leaf = (LNode) nodeFactor.getNode(this.leaf.next);
                this.iter = this.leaf.scanAll();
            } else {
                leaf = null;
                iter = null;
            }
        }

        @Override
        public boolean hasNext() {
            return this.iter != null;
        }

        @Override
        public Long next() {
            if (iter == null) {
                return null;
            }

            Long data = iter.next();
            if (!iter.hasNext()) {
                try {
                    advance();
                } catch (IOException e) {
                    System.out.println("BPlusTree Scan Error");
                    System.exit(0);
                }
            }
            return data;
        }
    }

    abstract class Node {

        protected long offset; // 该节点在文件中的保存位置
        //protected long prev;
        protected long next = -1L;
        protected short type;
        protected int num; //number of keys
        public List<typedData> keys;

        /**
         * 获取该键在节点中对应的位置(小于等于)
         *
         * @param key 键值
         * @return 可能的位置:存储位置/子节点位置
         */
        @SuppressWarnings("unused")
        abstract public int getLoc(typedData key);

        // returns null if no split, otherwise returns split info
        abstract public Split insert(typedData key, long value) throws IOException;

        /**
         * @return 从文件读取节点
         * @throws IOException 文件读取失败
         */
        @SuppressWarnings("unused")
        abstract public Node fromFile() throws IOException;

        /**
         * @throws IOException 写入到文件
         */
        abstract public void saveToFile() throws IOException;

        /**
         * 执行实际的写入操作
         *
         * @throws IOException 写入失败
         */
        @SuppressWarnings("unused")
        abstract void writeData() throws IOException;

        /**
         * 同步节点信息到文件中去
         *
         * @return 同步的节点
         * @throws IOException 同步写入失败
         */
        abstract public Node sync() throws IOException;
    }

    /**
     * 从当前文件位置构造新的节点
     */
    class NodeFactor {
        public Node getNode() throws IOException {
            short type = treeFile.readShort();
            if (type == INNER) {
                return new INode().fromFile();
            } else {
                return new LNode().fromFile();
            }
        }

        public Node getNode(long offset) throws IOException {
//            if (NodeCache.containsKey(offset)) {
//                //System.out.println("Hit cache");
//                return NodeCache.get(offset);
//            } else {
//                //System.out.println("Miss cache");
//            }

            treeFile.seek(offset);
            short type = treeFile.readShort();
            if (type == INNER) {
                Node node = new INode().fromFile();
                //NodeCache.put(offset, node);
                return node;
            } else {
                Node node = new LNode().fromFile();
                //NodeCache.put(offset, node);
                return node;
            }
        }
    }

    class LNode extends Node {

        // In some sense, the following casts are almost always illegal
        // (if Value was replaced with a real type other than Object,
        // the cast would fail); but they make our code simpler
        // by allowing us to pretend we have arrays of certain types.
        // They work because type erasure will erase the type variables.
        // It will break if we return it and other people try to use it.
        private List<Long> values = new ArrayList<>();

        {
            keys = new ArrayList<>();
            type = LEAF;
        }

        /**
         * Returns the position where 'key' should be inserted in a leaf node
         * that has the given keys.
         */
        public int getLoc(typedData key) {
            // Simple linear search. Faster for small values of N or M, binary search would be faster for larger M / N
            for (int i = 0; i < num; i++) {
                if (keys.get(i).compareTo(key) >= 0) {
                    return i;
                }
            }
            return num;
        }


        public Split insert(typedData key, long value) throws IOException {
            // Simple linear search
            int i = getLoc(key);
            if (this.num == M) { // The node was full. We must split it
                int mid = (M + 1) / 2;
                int sNum = this.num - mid;
                LNode sibling = new LNode();

                sibling.num = sNum;
                sibling.keys = keys.subList(mid, mid + sNum);
                sibling.values = values.subList(mid, mid + sNum);
                // 相当于把后半部分保存到新建的叶子节点上
                this.num = mid;

                sibling.next = this.next;
                sibling.saveToFile(); // 保存新建的节点到文件
                this.next = sibling.offset; // 同时更新链表情况

                if (i < mid) {
                    // Inserted element goes to left sibling
                    this.insertNonfull(key, value, i);
                } else {
                    // Inserted element goes to right sibling
                    sibling.insertNonfull(key, value, i - mid);
                    this.sync();
                }
                // Notify the parent about the split
                Split result = new Split(sibling.keys.get(0), //make the right's key >= result.key
                        this.offset,
                        sibling.offset);
                return result;
            } else {
                // The node was not full
                this.insertNonfull(key, value, i);
                return null;
            }
        }

        public boolean remove(typedData key) throws IOException {
            int loc = getLoc(key);
            if (loc < num && keys.get(loc).compareTo(key) == 0) {
                keys.remove(loc);
                values.remove(loc);
                num--;
                sync();
                return true;
            }
            return false;
        }

        private void insertNonfull(typedData key, long value, int idx) throws IOException {
            //if (idx < M && keys[idx].equals(key)) {
            if (idx < num && keys.get(idx).equals(key)) {
                // We are inserting a duplicate value, simply overwrite the old one
                values.set(idx, value);
            } else {
                // The key we are inserting is unique

                keys.add(idx, key);
                values.add(idx, value);
                num++;
            }
            this.sync();
        }


        public LNode next() throws IOException {
            if (next != -1L) {
                return (LNode) nodeFactor.getNode(next);
            }
            return null;
        }

        /*
         * 从文件读取 Node
         *
         */
        @Override
        public Node fromFile() throws IOException {
            // 调用应该首先将文件seek到指定偏移量位置
            offset = treeFile.getFilePointer() - Short.BYTES;
            num = treeFile.readInt();
            next = treeFile.readLong();
            for (int i = 0; i < num; i++) {
                keys.add(i, typedDataFactor.getTypedData(keyType).readFromFile(treeFile));
                values.add(i, treeFile.readLong());
            }
            return this;
        }


        /**
         * 叶子节点的填充情况
         * | type | num (number of keys)  | next (next leaf node offset) | [M] key with [M] value STAGGERED     |
         * | 2    |        4              | 8                            | M * sizeof(key) +  M * 8             |
         */
        @Override
        public void saveToFile() throws IOException {
            treeFile.seek(treeFile.length()); // 写到文件末尾

            this.offset = treeFile.getFilePointer(); // 保存当前节点在文件中的偏移量

            writeData();
        }

        @Override
        void writeData() throws IOException {
            ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES + Integer.BYTES + Long.BYTES + M * keyType.size() + M * Long.BYTES);
            buffer.putShort(type);
            buffer.putInt(num);
            buffer.putLong(next);


            for (int i = 0; i < num; i++) {
                buffer.put(keys.get(i).toBytes());
                buffer.putLong(values.get(i));
            }
            for (int i = num; i < M; i++) {
                byte[] bytes = new byte[keyType.size()];
                Arrays.fill(bytes, (byte) 0);
                buffer.put(bytes);
                buffer.putLong(-1L);
            }

            treeFile.write(buffer.array());
        }

        @Override
        public Node sync() throws IOException {
            treeFile.seek(this.offset);
            writeData();
            return this;
        }

        private Iterator<Long> scanAll() {
            return values.iterator();
        }

        private Iterator<Long> scanGreaterEqual(typedData key) {
            int idx = getLoc(key);
            return values.subList(idx, num).iterator();
        }

        private Iterator<Long> scanEqual(typedData key) {
            int idx = getLoc(key);
            return values.subList(idx, num).iterator();
        }
    }

    class INode extends Node {

        final Long[] children = new Long[N + 1];

        INode() {
            keys = new ArrayList<>();
            type = INNER;
        }

        /**
         * Returns the position where 'key' should be inserted in an inner node
         * that has the given keys.
         */
        public int getLoc(typedData key) {
            // Simple linear search. Faster for small values of N or M
            for (int i = 0; i < num; i++) {
                if (keys.get(i).compareTo(key) > 0) {
                    return i;
                }
            }
            return num;
            // Binary search is faster when N or M is big,
        }

        public Split insert(typedData key, long value) throws IOException {
            /* Early split if node is full.
             * This is not the canonical algorithm for B+ trees,
             * but it is simpler and it does break the definition
             * which might result in immature split, which might not be desired in database
             * because additional split lead to tree's height increase by 1, thus the number of disk read
             * so first search to the leaf, and split from bottom up is the correct approach.
             */

            if (this.num == N) { // Split
                int mid = (N + 1) / 2;
                int sNum = this.num - mid;
                INode sibling = new INode();
                sibling.num = sNum;

                sibling.keys = this.keys.subList(mid, mid + sNum);
                System.arraycopy(this.children, mid, sibling.children, 0, sNum + 1);

                this.num = mid - 1;//this is important, so the middle one elevate to next depth(height), inner node's key don't repeat itself

                sibling.saveToFile();
                this.sync();
                // Set up the return variable
                Split result = new Split(this.keys.get(mid - 1),
                        this.offset,
                        sibling.offset);

                // Now insert in the appropriate sibling
                if (key.compareTo(result.key) < 0) {
                    this.insertNonfull(key, value);
                } else {
                    sibling.insertNonfull(key, value);
                }
                return result;

            } else {// No split
                this.insertNonfull(key, value);
                return null;
            }
        }

        private void insertNonfull(typedData key, long value) throws IOException {
            // Simple linear search

            int idx = getLoc(key);
            Node child = nodeFactor.getNode(children[idx]);
            Split result = child.insert(key, value);

            if (result != null) {
                if (idx == num) {
                    // Insertion at the rightmost key
                    keys.add(idx, result.key);
                    children[idx] = result.left;
                    children[idx + 1] = result.right;
                    num++;
                } else {
                    // Insertion not at the rightmost key
                    //shift i>idx to the right

                    System.arraycopy(children, idx, children, idx + 1, num - idx + 1);

                    children[idx] = result.left;
                    children[idx + 1] = result.right;
                    keys.add(idx, result.key);
                    num++;
                }
                this.sync();
            } // else the current node is not affected

        }


        @Override
        public Node fromFile() throws IOException {
            offset = treeFile.getFilePointer() - Short.BYTES;
            num = treeFile.readInt();
            for (int i = 0; i < N; i++) {
                if (i < num)
                    keys.add(i, typedDataFactor.getTypedData(keyType).readFromFile(treeFile));
                else {
                    typedDataFactor.getTypedData(keyType).readFromFile(treeFile);
                }
            }
            for (int i = 0; i < N + 1; i++) {
                if (i < num + 1)
                    children[i] = treeFile.readLong();
                else {
                    treeFile.readLong();
                }
            }
            return this;
        }

        /**
         * 内部节点的填充情况
         * | type | num (key number) | N  key          | N + 1 offset of children |
         * |   2  | 4                | N * sizeof(key) |  (N+1) * 8               |
         */
        @Override
        public void saveToFile() throws IOException {
            treeFile.seek(treeFile.length());
            this.offset = treeFile.getFilePointer();
            writeData();
        }

        @Override
        void writeData() throws IOException {
            ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES + Integer.BYTES + N * keyType.size() + (N + 1) * Long.BYTES);
            buffer.putShort(type);
            buffer.putInt(num);
            for (int i = 0; i < N; i++) {
                if (i < num) {
                    buffer.put(keys.get(i).toBytes());
                } else {
                    buffer.put(new byte[keyType.size()]);
                }
            }
            for (int i = 0; i < N + 1; i++) {
                if (i <= num) {
                    buffer.putLong(children[i]);
                } else {
                    buffer.putLong(-1L);
                }
            }
            treeFile.write(buffer.array());
        }

        @Override
        public Node sync() throws IOException {
            treeFile.seek(this.offset);
            writeData();
            return this;
        }
    }

    class Split {
        private final typedData key;
        private final Long left;
        private final Long right;

        Split(typedData k, Long l, Long r) {
            key = k;
            left = l;
            right = r;
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("test.bin");
        if (file.delete()) {
            System.out.println(file.getName() + " 文件已被删除！");
        } else {
            System.out.println("文件删除失败！");
        }
        BPlusTree st = new BPlusTree(4, 3, Type.intType(), "test.bin", 16);
        st.insert(new intData(4), 4);
        st.insert(new intData(5), 5);
        st.insert(new intData(6), 6);
        st.insert(new intData(7), 7);
        st.insert(new intData(8), 8);
        st.insert(new intData(9), 9);
        st.insert(new intData(10), 10);
        st.insert(new intData(11), 11);
        st.insert(new intData(12), 12);
        st.insert(new intData(13), 13);
        st.insert(new intData(14), 14);
        st.insert(new intData(15), 15);
        st.insert(new intData(16), 16);
        System.out.println(st.scanEqual(new intData(7)));
        BPlusTreeIterator l = st.scanGreaterEqual(new intData(11));
        Long d = l.next();
        while (d != null) {
            System.out.println("value=" + d);
            d = l.next();
        }
    }
}