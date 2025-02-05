class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if (prev != null) {
            if (first == null && root.val <= prev.val) {
                first = prev;
            } 
            // Using else if here is restrictive because it does not allow 
            // the second condition to be evaluated if the first condition was true 
            // for the same pair of nodes. 
            if (first != null && root.val <= prev.val) {
                second = root;
            }
        }

        prev = root;
        helper(root.right);
    }
}

/* 1 5 3 4 2 6
5 3 和 4 2 
第一个node是5，第二个node是2
交换之后变成：1 2 3 4 5 6

prev.val > curr.val
first = prev
second = curr

BST: inorder - left, root, right，确保顺序检查当前root跟之前prev的对比
*/