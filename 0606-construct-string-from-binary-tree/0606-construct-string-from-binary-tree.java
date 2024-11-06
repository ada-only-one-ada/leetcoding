class Solution {
    public String tree2str(TreeNode root) {
        return helper(root);
    }

    public String helper(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if (root.left != null && root.right != null) {
            String left = "(" + helper(root.left) + ")";
            String right = "(" + helper(root.right) + ")";
            sb.append(left).append(right);

        } else if (root.left != null) {
            String left = "(" + helper(root.left) + ")";
            sb.append(left);

        } else if (root.right != null) {
            String right = "(" + helper(root.right) + ")";
            sb.append("()").append(right);
        } 

        return sb.toString();
    }
}