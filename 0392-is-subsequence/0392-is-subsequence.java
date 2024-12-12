class Solution {
    public boolean isSubsequence(String s, String t) {
        int checkIndex = 0;

        int i = 0;
        while (checkIndex < s.length() && i < t.length()) {
            if (s.charAt(checkIndex) == t.charAt(i)) {
                checkIndex++;
                i++;
            } else {
                i++;
            }
        }

        return checkIndex == s.length();
    }
}