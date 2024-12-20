class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(s1, 0, s2, 0, s3, 0, memo);
    }

    public boolean helper(String s1, int p1, String s2, int p2, String s3, int index, Boolean[][] memo) {
        if (index == s3.length()) {
            return p1 == s1.length() && p2 == s2.length();
        }
        
        if (memo[p1][p2] != null) return memo[p1][p2];

        char c1 = p1 < s1.length() ? s1.charAt(p1) : '-';
        char c2 = p2 < s2.length() ? s2.charAt(p2) : '-';
        char target = s3.charAt(index);

        boolean res = false;
        if (c1 == target) {
            res = helper(s1, p1 + 1, s2, p2, s3, index + 1, memo);
        }
        if (c2 == target) {
            res |= helper(s1, p1, s2, p2 + 1, s3, index + 1, memo);
        }

        memo[p1][p2] = res;
        return res;
    }
}
