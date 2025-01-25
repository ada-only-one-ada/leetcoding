class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
    
        TreeNode preRoot = null;
        TreeNode curr = root;

        while (curr != null) {
            preRoot = curr;

            if (val < curr.val){
                curr = curr.left;
            } else if (val > curr.val) {
                curr = curr.right;
            }
        }

        if (val > preRoot.val){
            preRoot.right = new TreeNode(val);
        } else{
            preRoot.left = new TreeNode(val);
        }
        
        return root;
    }
}