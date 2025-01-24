class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);   
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int originalColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if (image[sr][sc] == color) return;
        if (image[sr][sc] != originalColor) return;

        image[sr][sc] = color;
        dfs(image, sr - 1, sc, color, originalColor);
        dfs(image, sr + 1, sc, color, originalColor);
        dfs(image, sr, sc - 1, color, originalColor);
        dfs(image, sr, sc + 1, color, originalColor);
    }
}