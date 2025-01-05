class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
        0 1 2 3
        ------------
        2
        3 4
        6 5 7 （5可以由3过来，也可以由4过来）
        4 1 8 3 （1可以由6过来，也可以由5过来；8可以由5过来，也可以由7过来）

        过程：
         0  1  2  3 
        [2]
        [5,6]
        [11,10,13]   
        */

        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for (int row = 1; row < triangle.size(); row++) {
            for (int col = row; col >= 0; col--) {
                int number = triangle.get(row).get(col);
                int minPathSum = Integer.MAX_VALUE;

                if (col - 1 >= 0) minPathSum = Math.min(minPathSum, number + dp[col - 1]);
                if (dp[col] != Integer.MAX_VALUE) minPathSum = Math.min(minPathSum, number + dp[col]);

                dp[col] = minPathSum;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int sum: dp) {
            min = Math.min(min, sum);
        }

        return min;
    }
}