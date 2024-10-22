class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: nums) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (String s: map.keySet()) {
            if (s.length() >= target.length()) continue;
            if (target.indexOf(s) != 0) continue;

            String other = target.substring(s.length());
            if (map.containsKey(other)) {
                int freq = map.get(other);

                if (s.equals(other)) {
                    res += (freq - 1) * freq;
                } else {
                    res += freq * map.get(s);
                }
            }
        }

        return res;
    }
}