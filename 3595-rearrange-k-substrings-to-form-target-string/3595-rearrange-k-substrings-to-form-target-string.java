class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if (s.length() % k != 0) return false;
        if (s.length() != t.length()) return false;

        Map<String, Integer> targetMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        int len = s.length() / k;
        
        for (int i = 0; i + len - 1 < s.length(); i += len) {
            String ts = t.substring(i, i + len);
            String ss = s.substring(i, i + len);

            targetMap.put(ts, targetMap.getOrDefault(ts, 0) + 1);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }

        for (String key: targetMap.keySet()) {
            if (!map.containsKey(key)) return false;
            System.out.println(map.get(key));
            System.out.println(targetMap.get(key));

            if (!map.get(key).equals(targetMap.get(key))) return false;
        }

        return true;
    }
}