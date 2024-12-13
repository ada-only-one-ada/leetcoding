class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // 左子树肯定是完整的
        if (leftHeight == rightHeight) {
            return 1 + getCompleteNodes(leftHeight) + countNodes(root.right);
        // 右子树肯定是完整的
        } else if (leftHeight > rightHeight) {
            return 1 + getCompleteNodes(rightHeight) + countNodes(root.left);
        }

        return 0;
    }

    public int getCompleteNodes(int height) {
        return (int)Math.pow(2, height) - 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    } 
}