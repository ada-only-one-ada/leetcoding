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

        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) { 
        if (!map.containsKey(val)) return false;

        int removedIndex = map.get(val); // 找到要移除的那个数字的index
        int lastNum = list.get(list.size() - 1); // 找到当前list的最后的数字
        
        list.set(removedIndex, lastNum); 
        map.put(lastNum, removedIndex); // 把之前弄走的 val 的index 分给最后一个数字
        list.remove(list.size() - 1); // 把最后一个数字从list移除
       
        map.remove(val); // 移除当前要弄走的 val

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