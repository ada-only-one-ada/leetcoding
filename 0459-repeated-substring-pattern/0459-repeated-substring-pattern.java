class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) return false;

        // pattern must repeat at least twice, i.e. pattern length is at most n/2, at least 1.

        for (int i = 0; i + 1 <= s.length() / 2; i++) {
            String substring = s.substring(0, i + 1);

            // s length must can be divided by the pattern length
            if (s.length() % substring.length() != 0) continue;
            int times = s.length() / substring.length();

            String combined = substring.repeat(times);
            if (s.equals(combined)) return true;
        }

        return false;
    }
}