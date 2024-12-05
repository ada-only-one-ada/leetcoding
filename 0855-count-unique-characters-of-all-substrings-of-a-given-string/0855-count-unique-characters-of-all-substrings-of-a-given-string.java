class Solution {
    public int uniqueLetterString(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            
            while (left >= 0 && s.charAt(left) != s.charAt(i)) {
                left--;
            }

            while (right < s.length() && s.charAt(right) != s.charAt(i)) {
                right++;
            }

            res += (i - left) * (right - i);
        }

        return res;
    }
}