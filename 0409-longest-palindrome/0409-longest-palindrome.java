class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int res = 0;
        for (int times : freq) {
            if (times % 2 == 1) {
                if (res % 2 == 0) {
                    res += times;
                } else {
                    res += times - 1;
                }
            } else if (times % 2 == 0) {
                res += times;
            }
        }

        return res;
    }
}