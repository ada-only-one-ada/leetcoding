class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;

        int squre = (int)Math.sqrt(n);
        for (int i = 1; i <= squre; i++) {
            if (n % i == 0) {
                count++;
            }

            if (count == k) return i;
        }

        if (squre * squre == n) count--;
        for (int i = squre; i >= 1; i--) {
            if (n % i == 0) {
                count++;
            }

            if (count == k) {
                return n / i;
            }
        }

        return -1;
    }
}