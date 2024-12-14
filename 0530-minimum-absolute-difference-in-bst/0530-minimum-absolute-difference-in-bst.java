class Solution {
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack();
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode curr = stack.pop();
                if (prev != null && curr.val - prev.val < res) {
                    res = curr.val - prev.val;
                }

                prev = curr;
                root = curr.right;
            }
        }

        return res;
    }
}