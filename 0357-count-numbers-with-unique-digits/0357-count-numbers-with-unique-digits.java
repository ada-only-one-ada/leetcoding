class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int k = 9;
        for (int i = 0; i < n - 1; i++) {
            k *= (9 - i);
        }
        return k + countNumbersWithUniqueDigits(n - 1);
    }
}