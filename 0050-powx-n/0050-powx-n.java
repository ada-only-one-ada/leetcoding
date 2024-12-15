class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1 || x == 1) return x;

        // 这个处理负次方的情况
        if (n == -1) return 1/x;

        // 不要一直调用函数，一样的话存起来就好
        double half = myPow(x, n/2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * myPow(x, n % 2);
        }
    }
}

/*
TLE case:
x = 0.00001
n = 2147483647

StackOverflowError case:
x = 1.00000
n = -2147483648

x = 2.00000
n = -2147483648

if (n < 0) return myPow(1/x, -n); -(min) will cause error        
*/