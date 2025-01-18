class Solution {
    public boolean checkPartitioning(String s) {
        // Three non-empty palindromic substrings

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(j);

                if (c1 == c2) {
                    if (i == j || i + 1 == j) {
                        isPalindrome[i][j] = true;
                    } else if (i + 1 < j) {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j + 1 < s.length(); j++) {
                if (isPalindrome[0][i] && isPalindrome[i+1][j] && isPalindrome[j+1][s.length()-1]) {
                    return true;
                }
            }
        }
        return false;
    }
}