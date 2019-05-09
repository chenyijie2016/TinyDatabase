public class Row extends RowDisk {
    public boolean isCached = true; // 是否只存在于内存中

    public Row(Table t) {
        super(t);
    }
}
