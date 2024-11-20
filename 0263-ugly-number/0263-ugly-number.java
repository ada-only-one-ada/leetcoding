class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false; // 不是positive，不是丑数
        if (n == 1) return true;  // 除不下去了且等于1的时候，是丑数

        if (n % 2 == 0) {
            return isUgly(n / 2);
        } else if (n % 3 == 0) {
            return isUgly(n / 3);
        } else if (n % 5 == 0) {
            return isUgly(n / 5);
        }

        return false;
    }
}