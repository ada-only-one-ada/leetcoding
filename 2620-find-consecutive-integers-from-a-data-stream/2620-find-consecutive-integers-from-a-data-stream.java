class DataStream {
    int value;
    int k;
    Map<Integer, Integer> map = new HashMap<>();
    
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        map.put(value, 0);
    }
    
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