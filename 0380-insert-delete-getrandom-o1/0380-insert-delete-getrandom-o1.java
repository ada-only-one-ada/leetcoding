class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size()); // 新开一个index
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int removedIndex = map.get(val);
        int lastNum = list.get(list.size() - 1);
        list.set(removedIndex, lastNum);
        map.put(lastNum, removedIndex);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */