class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // Each node has a unique value
        
        int[] findX = helper(root, x, null, 0);
        int[] findY = helper(root, y, null, 0);

        return findX[0] != findY[0] && findX[1] == findY[1];
    }

    public int[] helper(TreeNode root, int val, TreeNode parent, int level) {
        if (root == null) return new int[]{-1, -1};

        if (root.val == val && parent != null) {
            return new int[]{parent.val, level};
        }

        int[] left = helper(root.left, val, root, level + 1);
        int[] right = helper(root.right, val, root, level + 1);

        if (left[0] != -1) {
            return left;
        } else {
            return right;
        }
    }
}