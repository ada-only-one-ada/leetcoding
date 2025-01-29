class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || n == 1) return x;
        if (n == -1) return 1 / x;
        if (n == 0) return 1;
        if (x == 0) return 0;
        
        double half = myPow(x, n / 2);

        return half * half * (n % 2 == 0? 1 : myPow(x, n % 2));
    }
}