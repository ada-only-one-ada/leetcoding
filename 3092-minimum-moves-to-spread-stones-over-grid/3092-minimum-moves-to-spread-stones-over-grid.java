class Solution {
    List<int[]> hasExtra = new ArrayList<>();
    boolean[] used;
    List<int[]> empty = new ArrayList<>();
    int minMoves = Integer.MAX_VALUE;

    public int minimumMoves(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] >= 2) {
                    for (int i = 0; i < grid[row][col] - 1; i++) {
                        hasExtra.add(new int[]{row, col});
                    }
                } else if (grid[row][col] == 0) {
                    empty.add(new int[]{row, col});
                }
            }
        }

        used = new boolean[hasExtra.size()];
        backtracking(0, 0);
        return minMoves;
    }

    public void backtracking(int emptyIndex, int currMoves) {
        if (emptyIndex == empty.size()) {
            minMoves = Math.min(minMoves, currMoves);
            return;
        }

        int[] toCell = empty.get(emptyIndex);
        int toRow = toCell[0];
        int toCol = toCell[1];

        for (int i = 0; i < hasExtra.size(); i++) {
            int[] from = hasExtra.get(i);
            int fromRow = from[0];
            int fromCol = from[1];
            if (used[i]) continue;

            used[i] = true;
            int distance = Math.abs(fromRow - toRow) + Math.abs(fromCol - toCol);
            backtracking(emptyIndex + 1, currMoves + distance);
            used[i] = false;
        }
    }
}