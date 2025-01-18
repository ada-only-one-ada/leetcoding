class Solution {
    public int minimumArea(int[][] grid) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    top = Math.min(top, row);
                    bottom = Math.max(bottom, row);
                    left = Math.min(left, col);
                    right = Math.max(right, col);
                }
            }
        }

        System.out.println("top " + top);
        System.out.println("bottom " + bottom);
        System.out.println("left " + left);
        System.out.println("right " + right);

        return (bottom - top + 1) * (right - left + 1);
    }
}