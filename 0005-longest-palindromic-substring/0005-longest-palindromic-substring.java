class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String res1 = check(s, i, i);
            String res2 = check(s, i, i + 1);

            if (res1.length() > res.length()) {
                res = res1;
            } 

            if (res2.length() > res.length()) {
                res = res2;
            }
        }

        return res;
    }

    public String check(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}