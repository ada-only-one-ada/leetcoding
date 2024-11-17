class Solution {
    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        int prevSum = 0;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.right;
            } else {
                TreeNode node = stack.pop();
                node.val += prevSum;
                prevSum = node.val;
                if (node.left != null) curr = node.left;
            }
        }

        return root;
    }
}