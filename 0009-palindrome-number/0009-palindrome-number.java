class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int copyX = x;
        int num = 0;

        while (copyX > 0) {
            num = num * 10 + copyX % 10;            
            copyX /= 10;

            if (num > x) return false;
        }

        return num == x;
    }
}