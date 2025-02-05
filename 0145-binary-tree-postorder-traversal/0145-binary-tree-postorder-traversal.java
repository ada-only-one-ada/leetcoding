class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            } else {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    root = node.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}

// preorder: root, left, right
// inorder: left, root, right
// postorder: left, right, root 

// preorder变形：root，right，left，反转就是postorder