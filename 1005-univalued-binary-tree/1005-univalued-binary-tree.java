public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.val != value) {
                return false;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return true;
    }
}
