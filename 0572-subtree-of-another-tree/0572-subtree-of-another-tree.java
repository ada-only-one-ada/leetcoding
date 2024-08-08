class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return helper(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (root.val == subRoot.val) {
            return helper(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
        } 

        return false;
    }
}

/*
Wrong case: [3,4,5,1,null,2], [3,1,2] should return false
需要在同一个递归树上
*/