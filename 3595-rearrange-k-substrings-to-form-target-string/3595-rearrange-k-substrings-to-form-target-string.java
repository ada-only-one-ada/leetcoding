class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if (s.length() % k != 0) return false;
        if (s.length() != t.length()) return false;

        Map<String, Integer> targetMap = new HashMap<>();
        int len = s.length() / k;
        
        for (int i = 0; i + len - 1 < s.length(); i += len) {
            String ts = t.substring(i, i + len);
            targetMap.put(ts, targetMap.getOrDefault(ts, 0) + 1);
        }

        for (int i = 0; i + len - 1 < s.length(); i += len) {
            String ss = s.substring(i, i + len);
            if (!targetMap.containsKey(ss)) return false;

            targetMap.put(ss, targetMap.get(ss) - 1);
            if (targetMap.get(ss) == 0) targetMap.remove(ss);
        }

        return true;
    }
}