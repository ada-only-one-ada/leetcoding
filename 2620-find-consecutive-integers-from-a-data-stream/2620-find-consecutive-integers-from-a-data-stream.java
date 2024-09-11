class DataStream {
    int value;
    int k;
    Map<Integer, Integer> map = new HashMap<>();
    
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        map.put(value, 0);
    }
    
    // 只把等于value的数字计入map，如果下次遇到了非value的值，清空map重新统计
    public boolean consec(int num) {
        if (num != value) {
            map.put(value, 0);
            return false;
        } else {
            map.put(value, map.get(value) + 1);
            if (map.get(value) >= k) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */