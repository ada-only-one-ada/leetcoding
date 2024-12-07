class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char w = s.charAt(i);
            char pattern = t.charAt(i);

            if (map.containsKey(w)) {
                if (map.get(w) != pattern) return false;
            } else {
                if (map.containsValue(pattern)) return false;
                map.put(w, pattern);
            }
        }

        return true;
    }
}