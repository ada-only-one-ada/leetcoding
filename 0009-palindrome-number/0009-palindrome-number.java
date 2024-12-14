class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        // 1221
        int sum = 0;
        int copy = x;

        while (copy > 0) {
            sum = sum * 10 + copy % 10;
            copy /= 10;   
            if (sum == x) return true;        
        }

        return sum == x;
    }
}