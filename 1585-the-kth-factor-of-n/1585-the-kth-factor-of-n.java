class Solution {
    public int kthFactor(int n, int k) {
        int sqrt = (int) Math.sqrt(n);
        int count = 0;
        
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }
        
        for (int i = sqrt; i >= 1; i--) {
            // Avoid counting the square root twice if n is a perfect square
            if (n % i == 0 && n / i != i) { 
                count++;
                if (count == k) {
                    return n / i;
                }
            }
        }

        return -1;
    }
}
