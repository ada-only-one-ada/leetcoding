class SnapshotArray {
    // 存每个index(key) 的历史修改记录，treemap 的 key 是snapId，value 是对应的在snapId时修改的值
    Map<Integer, TreeMap<Integer, Integer>> history = new HashMap<>();
    int currSnapId = 0;

    public SnapshotArray(int length) {}
    
    public void set(int index, int val) {
        // 这个index之前没有修改过，新建一个key value pair
        history.putIfAbsent(index, new TreeMap<>());
        // 加入当前 snapId 和修改的值
        history.get(index).put(currSnapId, val);
    }
    
    public int snap() {
        return currSnapId++;
    }
    
    public int get(int index, int snap_id) {
        // 当前index没有修改记录，默认是0
        if (!history.containsKey(index)) {
            return 0;
        }
        TreeMap<Integer, Integer> changes = history.get(index);
        // 获取距离 snap_id 最近的快照数据(即小于等于snap_id最大的那个)
        Integer lastSnapId = changes.floorKey(snap_id);
        // 不存在默认为0
        if (lastSnapId == null) {
            return 0;
        }

        return changes.get(lastSnapId);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */