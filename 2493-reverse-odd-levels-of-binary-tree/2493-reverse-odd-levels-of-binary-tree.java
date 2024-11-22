class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        int level = 0;

        List<TreeNode> prevLevelNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currLevelNodes = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currLevelNodes.add(node);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (level % 2 == 1) Collections.reverse(currLevelNodes);

            if (prevLevelNodes.size() != 0) {
                for (int i = 0; i < prevLevelNodes.size(); i++) {
                    prevLevelNodes.get(i).left = currLevelNodes.get(i*2);
                    prevLevelNodes.get(i).right = currLevelNodes.get(i*2+1);
                }
            }

            prevLevelNodes = new ArrayList<>(currLevelNodes);

            level++;
        }

        return root;
    }
}