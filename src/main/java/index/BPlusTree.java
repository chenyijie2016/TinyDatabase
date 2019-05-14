/**
 * B+ Tree
 * If you understand B+ or B Tree better, M & N don't need to be the same
 * Here is an example of M=N=4, with 12 keys
 * <p>
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
 */



/*
 * B+树节点在文件中的存储格式说明
 * 最先存储 freeList 的指针信息 偏移量(long 类型 8 byte) // 是否需要？
 * 存储节点信息如下:
 * 父节点偏移量(8 byte)
 * 前一个节点偏移量 (8 byte)
 * 后一个节点偏移量 (8 byte)
 *
 */

package index;

import data.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class BPlusTree {
    /**
     * Pointer to the root node. It may be a leaf or an inner node, but it is never null.
     */
    private long root;
    /**
     * the maximum number of keys in the leaf node, M must be > 0
     */
    private final int M;
    /**
     * the maximum number of keys in inner node, the number of pointer is N+1, N must be > 2
     */
    private final int N;

    private Type keyType;

    private RandomAccessFile treeFile;
    private final NodeFactor nodeFactor = new NodeFactor();
    /**
     * Create a new empty tree.
     */
    public static short INNER = 0;
    public static short LEAF = 1;

    public BPlusTree(int m, int n, Type type, String filename) throws IOException {
        M = m;
        N = n;
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


//        System.out.println(treeFile.length());

    }

    public void insert(typedData key, long value) throws IOException {
        System.out.println("insert key=" + key.toString());
        treeFile.seek(root);
        Node __root = nodeFactor.getNode();
        Split result = __root.insert(key, value);
        System.out.println("root Node has keys：" + __root.num);
        if (result != null) {// root节点出现分裂，需要新插入一个InnerNode,并且更新root节点位置为新的InnerNode
            // The old root was split into two parts.
            // We have to create a new root pointing to them

            INode _root = new INode();
            _root.num = 1;
            _root.keys[0] = result.key;
            _root.children[0] = result.left;
            _root.children[1] = result.right;
            _root.saveToFile();
            root = _root.offset;
            writeHeader();
        }
        __root.update();
        System.out.println("------------------");
    }

    public void writeHeader() throws IOException {
        treeFile.seek(0);
        treeFile.writeLong(root);
    }

    public void readHeader() throws IOException {
        treeFile.seek(0);
        root = treeFile.readLong();
    }

    /**
     * Looks for the given key. If it is not found, it returns null.
     * If it is found, it returns the associated value.
     */
    public Long find(typedData key) throws IOException {
        treeFile.seek(root);
        Node node = nodeFactor.getNode();
        while (node instanceof BPlusTree.INode) { // need to traverse down to the leaf
            INode inner = (INode) node;
            int idx = inner.getLoc(key);
            treeFile.seek(inner.children[idx]);
            node = nodeFactor.getNode();
        }
        // 循环结束后到达叶子节点
        //We are @ leaf after while loop
        LNode leaf = (LNode) node;
        int idx = leaf.getLoc(key);
        if (idx < leaf.num && leaf.keys[idx].compareTo(key)==0) {
            return leaf.values[idx];
        } else {
            return null;
        }
    }

//    public void dump() {
//        root.dump();
//    }


    abstract class Node {

        protected long offset; // 该节点在文件中的保存位置
        //protected long prev;
        protected long next = -1L;
        protected short type;
        protected int num; //number of keys
        protected typedData[] keys;

        abstract public int getLoc(typedData key);

        // returns null if no split, otherwise returns split info
        abstract public Split insert(typedData key, long value) throws IOException;

        abstract public void dump();

        abstract public Node fromFile() throws IOException;

        abstract public void saveToFile() throws IOException;

        abstract void writeData() throws IOException;

        abstract public Node update() throws IOException;
    }

    class NodeFactor {
        public Node getNode() throws IOException {
            System.out.println("==Read from file point:" + treeFile.getFilePointer() + "/" + treeFile.length());
            short type = treeFile.readShort();
            if (type == INNER) {
                return new INode().fromFile();
            } else {
                return new LNode().fromFile();
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
        final Long[] values = new Long[M];

        {
            keys = new typedData[M];
            type = LEAF;
        }

        /**
         * Returns the position where 'key' should be inserted in a leaf node
         * that has the given keys.
         */
        public int getLoc(typedData key) {
            // Simple linear search. Faster for small values of N or M, binary search would be faster for larger M / N
            for (int i = 0; i < num; i++) {
                if (keys[i].compareTo(key) >= 0) {
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
                System.arraycopy(this.keys, mid, sibling.keys, 0, sNum);
                System.arraycopy(this.values, mid, sibling.values, 0, sNum);// 相当于把后半部分保存到新建的叶子节点上
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
                    this.update();
                }
                // Notify the parent about the split
                Split result = new Split(sibling.keys[0], //make the right's key >= result.key
                        this.offset,
                        sibling.offset);
                return result;
            } else {
                // The node was not full
                this.insertNonfull(key, value, i);
                return null;
            }
        }

        private void insertNonfull(typedData key, long value, int idx) throws IOException {
            //if (idx < M && keys[idx].equals(key)) {
            if (idx < num && keys[idx].equals(key)) {
                // We are inserting a duplicate value, simply overwrite the old one
                values[idx] = value;
            } else {
                // The key we are inserting is unique
                System.arraycopy(keys, idx, keys, idx + 1, num - idx);
                System.arraycopy(values, idx, values, idx + 1, num - idx);

                keys[idx] = key;
                values[idx] = value;
                num++;
            }
            this.update();
        }

        public void dump() {
            System.out.println("lNode h==0");
            for (int i = 0; i < num; i++) {
                System.out.println(keys[i]);
            }
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
                keys[i] = typedDataFactor.getTypedData(keyType).readFromFile(treeFile);
                values[i] = treeFile.readLong();
            }
            return this;
        }


        /* 叶子节点的填充情况
         * | num (key数目)  | next  (下一个叶子节点) |      M 个 key 与 M 个value  交错排列        |
         * |        4      |         8             |      M * sizeof(key) +  M * 8              |
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
                buffer.put(keys[i].toBytes());
                buffer.putLong(values[i]);
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
        public Node update() throws IOException {
            treeFile.seek(this.offset);
            writeData();
            return this;
        }
    }

    class INode extends Node {
        //final Node[] children = new BPlusTree.Node[N + 1];

        final Long[] children = new Long[N + 1];

        INode() {
            keys = new typedData[N];
            type = INNER;
        }

        /**
         * Returns the position where 'key' should be inserted in an inner node
         * that has the given keys.
         */
        public int getLoc(typedData key) {
            // Simple linear search. Faster for small values of N or M
            for (int i = 0; i < num; i++) {
                if (keys[i].compareTo(key) > 0) {
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
                System.arraycopy(this.keys, mid, sibling.keys, 0, sNum);
                System.arraycopy(this.children, mid, sibling.children, 0, sNum + 1);

                this.num = mid - 1;//this is important, so the middle one elevate to next depth(height), inner node's key don't repeat itself

                sibling.saveToFile();
                this.update();
                // Set up the return variable
                Split result = new Split(this.keys[mid - 1],
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
            treeFile.seek(children[idx]);
            Node child = nodeFactor.getNode();
            Split result = child.insert(key, value);

            if (result != null) {
                if (idx == num) {
                    // Insertion at the rightmost key
                    keys[idx] = result.key;
                    children[idx] = result.left;
                    children[idx + 1] = result.right;
                    num++;
                } else {
                    // Insertion not at the rightmost key
                    //shift i>idx to the right
                    System.arraycopy(keys, idx, keys, idx + 1, num - idx);
                    System.arraycopy(children, idx, children, idx + 1, num - idx + 1);

                    children[idx] = result.left;
                    children[idx + 1] = result.right;
                    keys[idx] = result.key;
                    num++;
                }
                this.update();
            } // else the current node is not affected

        }

        /**
         * This one only dump integer key
         */
        public void dump() {
//            System.out.println("iNode h==?");
//            for (int i = 0; i < num; i++) {
//                children[i].dump();
//                System.out.print('>');
//                System.out.println(keys[i]);
//            }
//            children[num].dump();
        }

        @Override
        public Node fromFile() throws IOException {
            offset = treeFile.getFilePointer() - Short.BYTES;
            num = treeFile.readInt();
            for (int i = 0; i < N; i++) {
                keys[i] = typedDataFactor.getTypedData(keyType).readFromFile(treeFile);
            }
            for (int i = 0; i < N + 1; i++) {
                children[i] = treeFile.readLong();
            }
            return this;
        }

        /* 内部节点的填充情况
         * | num (key数目)  |      N 个 key           | N + 1 个节点偏移量          |
         * |        4      |      (N) * sizeof(key)  |  (N+1) * 8              |
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
                    buffer.put(keys[i].toBytes());
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
        public Node update() throws IOException {
            treeFile.seek(this.offset);
            writeData();
            return this;
        }
    }

    class Split {
        public final typedData key;
        public final Long left;
        public final Long right;

        public Split(typedData k, Long l, Long r) {
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
        BPlusTree st = new BPlusTree(3, 3, Type.intType(), "test.bin");
        st.insert(new intData(4), 4);
        st.insert(new intData(5), 5);
        st.insert(new intData(6), 6);
        st.insert(new intData(7), 7);
        st.insert(new intData(8), 8);
        st.insert(new intData(9), 9);
        st.insert(new intData(10), 10);
        st.insert(new intData(11), 11);
        st.insert(new intData(12), 12);

        System.out.println(st.find(new intData(7)));
//        st.dump();
//        System.out.println(st.find("asd"));
//        //st.dump();
    }
}