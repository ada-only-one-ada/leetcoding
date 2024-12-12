class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (!map.containsKey(sc)) {
                if (used.contains(tc)) {
                    return false;
                } else {
                    map.put(sc, tc);
                    used.add(tc);
                }
            } else {
                if (tc != map.get(sc)) {
                    return false;
                }
            }
        }

        return true;
    }
}