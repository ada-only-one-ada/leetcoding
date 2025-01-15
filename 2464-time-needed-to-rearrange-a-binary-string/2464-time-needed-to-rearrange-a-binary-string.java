class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int moves = 0;

        int countZeros = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                countZeros++;
            } else if (c == '1' && countZeros > 0) {
                moves = Math.max(moves + 1, countZeros);
            }
        }

        return moves;
    }
}