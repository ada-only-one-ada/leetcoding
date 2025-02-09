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
        return dp(n, k, row, column, 0);
    }
    
    private double dp(int n, int k, int row, int col, int moves) {
        // If out of bounds, the knight is off the board.
        if (row < 0 || col < 0 || row >= n || col >= n) return 0.0;
        
        // If no moves left, the knight is on the board.
        if (moves == k) return 1.0;
        
        // Return the cached result if already computed.
        if (memo[moves][row][col] != null) return memo[moves][row][col];
        
        double probability = 0.0;
        // Explore all possible knight moves.
        for (int[] dir : directions) {
            probability += dp(n, k, row + dir[0], col + dir[1], moves + 1) / 8.0;
        }
        
        // Cache the computed probability for current state.
        memo[moves][row][col] = probability;
        return probability;
    }
}
