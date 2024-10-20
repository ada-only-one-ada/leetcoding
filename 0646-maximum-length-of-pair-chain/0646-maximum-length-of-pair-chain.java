class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;
    
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        int[] prev = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            int[] curr = pairs[i];
            if (curr[0] > prev[1]) {
                dp[i] = dp[i - 1] + 1;
                prev = curr;
            } else {
                dp[i] = dp[i - 1];
                if (curr[1] < prev[1]) { // 选择性更新
                    prev = curr;
                }
            }
          
        } 

        return dp[dp.length - 1];
    }
}