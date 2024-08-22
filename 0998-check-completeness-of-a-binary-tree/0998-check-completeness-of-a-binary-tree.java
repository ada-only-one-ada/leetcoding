class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = getHeight(root);
        int currHeight = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            currHeight++;
            boolean prevSingle = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (currHeight == height) continue; // 叶子节点，不需要检查

                if (currHeight < height - 1) { // 小于叶子父母
                    if (node.left == null || node.right == null) {
                        return false;
                    }
                }

                if (currHeight == height - 1) { // 等于叶子父母
                    if (node.left == null && node.right != null) {
                        return false;
                    }
                    
                    if ((node.left != null || node.right != null )&& prevSingle) {
                        return false;
                    }

                    if ( i != size - 1 && (node.left == null || node.right == null)) {
                        prevSingle = true;
                    }
                } 
               
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}