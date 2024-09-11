class Solution {
    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: word1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (char c: word2.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);
        
        for (char key1: map1.keySet()) {
            for (char key2: map2.keySet()) {
                if (key1 == key2) {
                    // 注意了是互相换！两个一样的互相换，等于没换
                    if (map1.size() == map2.size()) return true;
                } else if (key1 != key2) {
                    int newMap1Size = map1.size();
                    if (!map1.containsKey(key2)) newMap1Size++;
                    if (map1.get(key1) == 1) newMap1Size--;

                    int newMap2Size = map2.size();
                    if (!map2.containsKey(key1)) newMap2Size++;
                    if (map2.get(key2) == 1) newMap2Size--;
                    
                    if (newMap1Size == newMap2Size) return true;
                }
            }
        }

        return false;
    }
}