class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int copyX = x;
        int num = 0;

        while (copyX > 0) {
            num = num * 10 + copyX % 10;            
            copyX /= 10;

            // 已经超过了，提前返回，不用再继续loop了
            if (num > x) return false;
        }

        return num == x;
    }
}