class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                if (map.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(pattern.charAt(i))) {
                    return false;
                } else {
                    map.put(words[i], pattern.charAt(i));
                }
            }
        }

        return true;
    }
}