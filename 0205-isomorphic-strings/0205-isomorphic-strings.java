class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> matched = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char w = s.charAt(i);
            char pattern = t.charAt(i);

            if (map.containsKey(w)) {
                if (map.get(w) != pattern) return false;
            } else {
                if (matched.contains(pattern)) return false;
                matched.add(pattern);
                map.put(w, pattern);
            }
        }

        return true;
    }
}