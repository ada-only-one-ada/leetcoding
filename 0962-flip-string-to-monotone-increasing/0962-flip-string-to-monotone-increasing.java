class Solution {
    public int minFlipsMonoIncr(String s) {
        int res = 0;

        int ones = 0;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                // 保留 0，之前的 1 都要flip
                // 不保留，反转加1
                res = Math.min(ones, res + 1);
            } else {
                ones++;
            }
        }

        return res;
    }
}