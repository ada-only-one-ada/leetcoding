class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }

        int MAX = Integer.MAX_VALUE; // 2,147,483,647

        int sum = 0;
        while (x > 0) {
            // if (sum > MAX / 10 || (sum == MAX / 10 && x % 10 > 7)) return 0;
            if (sum > MAX / 10) return 0;
            sum = sum * 10 + (x % 10);
            x /= 10;
        }

        return sum * sign;
    }
}