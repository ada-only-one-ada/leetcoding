class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int res = 0;
        for (int times : freq) {
            res += times / 2 * 2;

            if (times % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}