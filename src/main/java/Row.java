import data.typedData;
public class Row extends RowDisk {

    public static enum STATUS {
        OnlyInMemory, // 数据只存在于内存中
        OnlyInDisk, // 数据只存在于磁盘中，具有指向数据位置的指针
        MemoryDisk // 数据在磁盘和内存中均存在
    }


    public STATUS cachedStatus; // 数据的缓存状态

    public Row(Table t) {
        super(t, -1L);
    }

    public Row(Table t, long pos) {
        super(t, pos);
    }

    public Row setStatus(STATUS s) {
        this.cachedStatus = s;
        return this;
    }



}
