class Solution {
    public int maxScore(String s) {
        // 前缀0，后缀1

        int zero = 0;
        int[] zeros = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero++;
            }
            zeros[i] = zero;
        }

        int score = 0;
        int one = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '1') {
                one++;
            }
            score = Math.max(score, one + zeros[i - 1]);
        }

        return score; 
    }
}