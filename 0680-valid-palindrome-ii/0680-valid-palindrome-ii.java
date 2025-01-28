class Solution {
    public boolean validPalindrome(String s) {
        if (helper(s)) return true;

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
               return helper(s.substring(i + 1, j + 1)) || 
                helper(s.substring(i, j));
            } 

            i++;
            j--;
        }

        return false;
    }

    public boolean helper(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}