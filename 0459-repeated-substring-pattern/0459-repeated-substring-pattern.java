class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) return false;

        for (int i = 0; i < s.length()/ 2; i++) {
            String substring = s.substring(0, i + 1);

            if (s.length() % substring.length() != 0) continue;
            int times = s.length() / substring.length();

            String combined = substring.repeat(times);
            if (s.equals(combined)) return true;
        }

        return false;
    }
}