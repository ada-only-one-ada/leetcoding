class Solution {
    public boolean hasMatch(String s, String p) {
        // s = "l" and p = "*" return true
        if (p.charAt(0) == '*') {
            return s.contains(p.substring(1));
        }

        if (p.charAt(p.length() - 1) == '*') {
            return s.contains(p.substring(0, p.length() - 1));
        }

        int starIndex = p.indexOf("*");

        String before = p.substring(0, starIndex);
        String after = p.substring(starIndex + 1);

        int firstPartIndex = s.indexOf(before);
        if (firstPartIndex == -1) return false;

        int secondPartIndex = s.indexOf(after, firstPartIndex + before.length());

        if (secondPartIndex == -1) return false;
        return firstPartIndex < secondPartIndex;
    }
}