class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // 空树，直接创建 val 节点并返回
        if (root == null) {
            return new TreeNode(val);
        } 
        
        // 只有一个节点
        if (root.left == null && root.right == null) {
            // 如果 val 比 root 小，那么 root 的右子树 是 val 
            if (root.val > val) {
                root.right = new TreeNode(val);
                return root;
            // 如果 val 比 root 大，那么 val 的左子树是 root
            } else if (root.val < val) {
                TreeNode newRoot = new TreeNode(val);
                newRoot.left = root;
                return newRoot;
            }   
        }
        
        // 如果有多个节点，递归
        // 如果 val 比 root 小，那么 root 的右子树是递归（val） 
        if (root.val > val) {
            root.right = insertIntoMaxTree(root.right, val);
            return root; 
        // 如果 val 比 root 大，那么递归（val）的左子树是 root
        } else if (root.val < val) {
            TreeNode newRoot = insertIntoMaxTree(root.left, val);
            newRoot.left = root;
            return newRoot;
        }

        return null;
    }
}