class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: nums) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (String s: map.keySet()) {
            if (s.length() >= target.length()) continue;
            if (!s.equals(target.substring(0, s.length()))) continue;

            String other = target.substring(s.length());     
            if (map.containsKey(other)) {
                if (!s.equals(other)) {
                    res += map.get(other) * map.get(s);
                } else {
                    res += map.get(s) * (map.get(s) - 1);
                }
            }
        }

        return res;
    }
}