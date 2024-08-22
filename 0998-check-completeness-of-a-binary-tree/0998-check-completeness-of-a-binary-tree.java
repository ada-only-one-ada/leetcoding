class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        boolean nullNodeFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                nullNodeFound = true;
            } else if (node != null) {
                if (nullNodeFound == true) {
                    return false;
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}