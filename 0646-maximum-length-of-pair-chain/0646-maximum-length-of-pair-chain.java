class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] prev = pairs[0];
        int maxLen = 1;
        int currLen = 1; 
        for (int i = 1; i < pairs.length; i++) {
            int[] curr = pairs[i];

            if (curr[0] > prev[1]) {
                prev = curr;
                currLen++;
            } else {
                if (curr[1] < prev[1]) {
                    prev = curr;
                }
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}