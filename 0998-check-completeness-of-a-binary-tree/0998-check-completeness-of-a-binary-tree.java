class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = getHeight(root);
        int currHeight = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            currHeight++; // 拿到当前层数
            boolean prevSingle = false; // 存当前层当前节点的前面是不是有父母生了独生孩子
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (currHeight == height) continue; // 叶子节点，不需要检查

                // 小于叶子父母
                if (currHeight < height - 1) { 
                    // 左右孩子缺一不可
                    if (node.left == null || node.right == null) {
                        return false;
                    }
                }

                // 等于叶子父母
                if (currHeight == height - 1) { 
                    // 有右孩子，没左孩子，不行
                    if (node.left == null && node.right != null) {
                        return false; 
                    }
                    
                    // 之前出现过无右孩子的父母，现在又出现了左孩子，不行
                    if (node.left != null && prevSingle) {
                        return false;
                    }

                    // 当前层无右孩子标记
                    if (node.right == null) {
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