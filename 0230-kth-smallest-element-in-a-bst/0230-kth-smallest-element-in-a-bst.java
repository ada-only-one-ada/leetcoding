class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int count = 0;

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left; 
            } else if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                count++;

                if (count == k) return node.val;

                if (node.right != null) {
                    curr = node.right;
                }
            }
        }

        return -1;
    }
}