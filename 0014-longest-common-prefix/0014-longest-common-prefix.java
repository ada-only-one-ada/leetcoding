class Solution {
    public String longestCommonPrefix(String[] strs) {
        String candidate = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            // 这里不是-1，比如c和acc没有公共前缀
            while (s.indexOf(candidate) != 0) {
                candidate = candidate.substring(0, candidate.length() - 1);
            }
        }

        return candidate;
    }
}