class Solution {
    public int pivotInteger(int n) {
        if (n <= 1) return n;

        int total = (1 + n) * n / 2;
        int prefixSum = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum += i;
            if (prefixSum == total - prefixSum + i) {
                return i;
            }
        }

        return -1;
    }
}