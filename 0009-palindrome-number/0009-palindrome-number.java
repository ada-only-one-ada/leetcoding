class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x != 0 && x % 10 == 0) return false;

        int tens = 1;
        int copyX = x / 10;
        while (copyX > 0) {
            tens *= 10;
            copyX /= 10;
        }

        int sum = 0;
        copyX = x;
        while (copyX > 0) {
            sum += (copyX % 10) * tens;
            tens /= 10;
            copyX /= 10;
        }

        return sum == x;
    }
}