class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(0, curr.val);

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        return res;
    }
}