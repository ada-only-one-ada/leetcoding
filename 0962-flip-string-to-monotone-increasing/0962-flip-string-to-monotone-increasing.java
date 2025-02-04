class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones = 0;

        int res = 0;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                res = Math.min(ones, res + 1);
            } else {
                ones++;
            }
        }

        return res;
    }
}