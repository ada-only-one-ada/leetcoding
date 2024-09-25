class Solution {
    public boolean validPalindrome(String s) {
        if (helper(s)) return true;

        int left = 0;
        int right = s.length() - 1;
        int used = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                
                return helper(s.substring(left, right)) || helper(s.substring(left + 1, right + 1));
            }

            left++;
            right--;
            
        }
        return false;
    }

    public boolean helper(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}