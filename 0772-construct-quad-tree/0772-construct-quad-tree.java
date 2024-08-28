/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

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
        }

        Node root = new Node(false, false);
        root.topLeft = topLeft;
        root.topRight = topRight;
        root.bottomLeft = bottomLeft;
        root.bottomRight = bottomRight;

        return root;
    }
}