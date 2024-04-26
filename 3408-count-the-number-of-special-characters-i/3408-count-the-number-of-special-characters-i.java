class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        boolean[] visited = new boolean[26];
        int count = 0;

        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z' && !visited[c - 'a']) {
                if (upper.contains(Character.toUpperCase(c))) {
                    count++;
                    visited[c - 'a'] = true;
                }
                lower.add(c);
            } else {
                if (!visited[Character.toLowerCase(c) - 'a'] && lower.contains(Character.toLowerCase(c))) {
                    count++;
                    visited[Character.toLowerCase(c) - 'a'] = true;
                }
                upper.add(c);
            }
        }

        return count;
    }
}