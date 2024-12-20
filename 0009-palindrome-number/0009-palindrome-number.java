class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int sum = 0;
        int temp = x;

        while (temp > 0) {
            sum = sum * 10 + temp % 10;
            temp /= 10;   

            // 已经超过了，提前返回，不用再继续loop了
            if (sum > x) return false;      
        }

        return sum == x;
    }
}