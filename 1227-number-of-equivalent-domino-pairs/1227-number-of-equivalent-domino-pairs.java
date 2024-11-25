class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int[] domino: dominoes) {
            int a = domino[0];
            int b = domino[1];
            String state = a + "-" + b; 

            if (a == b) {
                map.put(state, map.getOrDefault(state, 0) + 1);
                continue;
            }

            String target = b + "-" + a; 

            if (map.containsKey(state)) res += map.get(state); // [1,2] 跟 [1,2]
            if (map.containsKey(target)) res += map.get(target); // [1,2] 跟 [2,1]
            
            map.put(state, map.getOrDefault(state, 0) + 1);
        }

        for (String key: map.keySet()) {
            if (key.charAt(0) == key.charAt(2)) { // [1,1] 跟 [1,1]
                res += map.get(key) * (map.get(key) - 1) / 2;
            }
        }

        return res;
    }
}