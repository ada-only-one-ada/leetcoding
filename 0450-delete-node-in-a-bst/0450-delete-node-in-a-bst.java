class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightMin = root.right;
                while (rightMin.left != null) {
                    rightMin = rightMin.left;
                }

                // 替代当前root的val
                root.val = rightMin.val;
                // 把最小那个删了
                root.right = deleteNode(root.right, rightMin.val);
                return root;
            }
        }

        return root;
    }
}