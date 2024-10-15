class Solution {
    public int longestStrChain(String[] words) {
        if (words.length == 0) return 0;
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int res = 1;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int i = 1; i < words.length; i++) {
            int start = 0;
            int end = i;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (words[mid].length() + 1 < words[i].length()) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            for (int j = start; j < i; j++) {
                if (words[j].length() + 1 > words[i].length()) break; // word[j] 长度太长
                
                if (isSubsequence(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                res = Math.max(dp[i], res);
            }
        }

        return res;
    }

    public boolean isSubsequence(String candidate, String word) {
        if (candidate.length() + 1 != word.length()) return false;

        int i = 0;
        int j = 0;
        while (i < candidate.length() && j < word.length()) {
            if (candidate.charAt(i) == word.charAt(j)) {
                i++;
            } 
            j++;
        }
        return i == candidate.length();
    }
}