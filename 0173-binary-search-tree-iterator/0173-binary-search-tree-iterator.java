/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    // in-order traversal: left - root - right
    Queue<TreeNode> queue;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        stack = new Stack();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                queue.add(node);
                if (node.right != null) {
                    curr = node.right;
                }
            }
        }
    }
    
    public int next() {
        return queue.poll().val;
    }
    
    public boolean hasNext() {
        return queue.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */