class Solution {
    public String longestCommonPrefix(String[] strs) {
        String candidate = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (s.indexOf(candidate) != 0) {
                candidate = candidate.substring(0, candidate.length() - 1);
            }
        }

        return candidate;
    }
}