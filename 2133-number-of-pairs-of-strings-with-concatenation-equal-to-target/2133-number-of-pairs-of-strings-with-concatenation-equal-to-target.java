class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: nums) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (String s: map.keySet()) {
            if (s.length() >= target.length()) continue;
            // if (!s.equals(target.substring(0, s.length()))) continue; //前半段要一致
            if (target.indexOf(s) != 0) continue;

            String other = target.substring(s.length());     
            if (map.containsKey(other)) {
                int freq = map.get(other);
                if (s.equals(other)) {
                    // 对于每一个s，都可以和剩下的组成pair，一共有freq个s
                    res += freq * (freq - 1);
                } else {
                    res += freq * map.get(s);
                }
            }
        }

        return res;
    }
}