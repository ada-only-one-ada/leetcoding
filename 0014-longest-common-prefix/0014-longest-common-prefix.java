class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String candidate = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currStr = strs[i];
            while (currStr.indexOf(candidate) != 0) {
                candidate = candidate.substring(0, candidate.length() - 1);
            }
        }

        return candidate;
    }
} 