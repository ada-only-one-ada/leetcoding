class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + getReversed(i) == num) {
                return true;
            }
        }

        return false;
    }

    public int getReversed(int num) {
        int prev = 0;

        while (num > 0) {
            prev = prev * 10 + (num % 10);
            num /= 10;
        }

        return prev;
    }
}