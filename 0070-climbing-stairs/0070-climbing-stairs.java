class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prevPrev = 1;
        int prev = 2;

        for (int i = 3; i <= n; i++) {
            int temp = prev;

            prev = prevPrev + prev;
            prevPrev = temp;
        }

        return prev;
    }
}