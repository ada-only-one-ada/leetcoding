class Solution {
    // All 8 possible knight moves.
    int[][] directions = {
        {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
        {-1, -2}, {1, -2}, {-1, 2}, {1, 2}
    };
    
    // 3D array for memoization: memo[movesLeft][row][col]
    Double[][][] memo;
    
    public double knightProbability(int n, int k, int row, int column) {
        memo = new Double[k + 1][n][n];
        return dp(n, k, row, column);
    }
    
    private double dp(int n, int k, int row, int col) {
        // If out of bounds, the knight is off the board.
        if (row < 0 || col < 0 || row >= n || col >= n) return 0.0;
        
        // If no moves left, the knight is on the board.
        if (k == 0) return 1.0;
        
        // Return the cached result if already computed.
        if (memo[k][row][col] != null) return memo[k][row][col];
        
        double probability = 0.0;
        // Explore all possible knight moves.
        for (int[] dir : directions) {
            probability += dp(n, k - 1, row + dir[0], col + dir[1]) / 8.0;
        }
        
        // Cache the computed probability for current state.
        memo[k][row][col] = probability;
        return probability;
    }
}
