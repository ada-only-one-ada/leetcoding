class Solution {
    char[][] flow;
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        flow = new char[heights.length][heights[0].length];
        for (int row = 0; row < heights.length; row++) {
            dfs(heights, row, 0, 'P');
            dfs(heights, row, heights[0].length - 1, 'A'); 
        }

        for (int col = 0; col < heights[0].length; col++) {
            dfs(heights, 0, col, 'P'); 
            dfs(heights, heights.length - 1, col, 'A'); 
        }

        return res;
    }

    public void dfs(int[][] heights, int row, int col, char ocean) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) return;
        if (flow[row][col] == ocean || flow[row][col] == 'B') return;

        if ((ocean == 'P' && flow[row][col] == 'A') || (ocean == 'A' && flow[row][col] == 'P')) {
            res.add(Arrays.asList(row, col)); 
            flow[row][col] = 'B';
        } else {
            flow[row][col] = ocean;
        }

        for (int[] direction: directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow < 0 || nextRow == heights.length || nextCol < 0 || nextCol == heights[0].length) continue;
            if (heights[row][col] > heights[nextRow][nextCol]) continue;

            dfs(heights, nextRow, nextCol, ocean);
        }
    }
}