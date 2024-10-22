class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int prevEnd = pairs[0][1];
        int maxLen = 1;
        int currLen = 1; 
        for (int i = 1; i < pairs.length; i++) {
            int currStart = pairs[i][0];
            int currEnd = pairs[i][1];

            if (currStart > prevEnd) {
                prevEnd = currEnd;
                currLen++;
            } else {
                prevEnd = Math.min(prevEnd, currEnd);
            }
            
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}