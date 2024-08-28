

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    // public Node(boolean val, boolean isLeaf) 构建时，先 val，再 isLeaf
    // (val, isLeaf) = (any, false)
    // (val, isLeaf) = (currChildren.val, true)
    public Node helper(int[][] grid, int i, int j, int len) {
        // 长度为1，肯定是leaf，val取决于当前格子的val
        if (len == 1) return new Node(grid[i][j] == 1, true); 

        int half = len / 2;
        Node topLeft = helper(grid, i, j, half);
        Node topRight = helper(grid, i, j + half, half);
        Node bottomLeft = helper(grid, i + half, j, half);
        Node bottomRight = helper(grid, i + half, j + half, half);

        // 四个一样的组成的大 leaf
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
        topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
            // return new Node(grid[i][j] == 1, true);  
        }

        // 不是 leaf，值为true 或者 false 都可以
        Node root = new Node(false, false);  // new Node(true, false);
        root.topLeft = topLeft;
        root.topRight = topRight;
        root.bottomLeft = bottomLeft;
        root.bottomRight = bottomRight;

        return root;
    }
}