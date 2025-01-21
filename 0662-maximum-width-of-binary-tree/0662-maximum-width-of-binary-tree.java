class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));

        while (!queue.isEmpty()) {
            int left = -1;
            int right = -1;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int id = pair.getValue();
                
                if (left == -1) left = id;
                if (i == size - 1) right = id;

                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * id));
                }

                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * id + 1));
                }
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}