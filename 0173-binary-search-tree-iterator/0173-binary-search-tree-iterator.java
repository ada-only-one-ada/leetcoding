class BSTIterator {
    TreeNode curr;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new Stack();    
    }
    
    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        TreeNode node = stack.pop();
        if (node.right != null) {
            curr = node.right;
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */