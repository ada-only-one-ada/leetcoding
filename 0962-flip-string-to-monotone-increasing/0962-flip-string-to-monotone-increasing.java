class Solution {
    public int minFlipsMonoIncr(String s) {
        int res = 0;

        int ones = 0;

        for (char c: s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else if (c == '0') {
                res = Math.min(ones, res + 1);
            }
        }

        return res;
    }
}