class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        
        dfs(image, image[sr][sc], color, sr, sc);
        return image;
    }

    public void dfs(int[][] image, int originalColor, int newColor, int row, int col) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length) return;
        if (image[row][col] != originalColor) return;
        // if (image[row][col] == newColor) return;

        image[row][col] = newColor;
        dfs(image, originalColor, newColor, row - 1, col);
        dfs(image, originalColor, newColor, row + 1, col);
        dfs(image, originalColor, newColor, row, col - 1);
        dfs(image, originalColor, newColor, row, col + 1);
    }
}