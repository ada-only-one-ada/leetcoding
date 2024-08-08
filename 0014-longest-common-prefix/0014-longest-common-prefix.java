class Solution {
    public String longestCommonPrefix(String[] strs) {
        String candidate = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            /* 
               这里不是-1，比如c和acc没有公共前缀
               ["c","acc","ccc"], not return "c" since it is not prefix!
               should not be -1, should be 0!
            */
            while (s.indexOf(candidate) != 0) {
                candidate = candidate.substring(0, candidate.length() - 1);
                if (candidate.length() == 0) break;
            }
        }

        return candidate;
    }
}