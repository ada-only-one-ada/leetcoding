class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
    
        List<Character>[] count = new ArrayList[s.length() + 1];
        for (char key: map.keySet()){
            if (count[map.get(key)] == null){
                count[map.get(key)] = new ArrayList<>();
            }
            count[map.get(key)].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int times = count.length - 1; times > 0; times--){
            if (count[times] == null) continue;

            for (char c: count[times]){
                for (int repeat = 0; repeat < times; repeat++){
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}