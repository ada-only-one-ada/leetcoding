class Solution {
    int[][] directions = {
        {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
        {-1, -2}, {1, -2}, {-1, 2}, {1, 2}
    };
    
    double[][][] memo;

    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[n][n][k + 1];
        return dp(n, k, row, column, 0);
    }
    
    private double dp(int n, int k, int row, int col, int moves) {
        if (row < 0 || col < 0 || row >= n || col >= n) return 0.0;
        
        if (moves == k) return 1.0;
        
        if (memo[row][col][moves] != 0.0) return memo[row][col][moves];
        
        double probability = 0.0;
        // Explore all possible knight moves.

        for (int[] dir : directions) {
            probability += dp(n, k, row + dir[0], col + dir[1], moves + 1) / 8.0;
        }
        
        // Cache the computed probability for current state.
        memo[row][col][moves] = probability;
        return probability;
    }
}
