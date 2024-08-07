class Solution {
    boolean res = true;
    
    public boolean isBalanced(TreeNode root) {
       // if (root == null) return true;
     
        getHeight(root);
        if (res == false) return false;
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (Math.abs(left - right) > 1) {
            res = false;
            return -1; // return -1 is just one answer for current call
        }

        return Math.max(left, right) + 1;
    }
}