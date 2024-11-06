class Solution {
    List<TreeNode> nodes = new ArrayList<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int depth = getDepth(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (level == depth) nodes.add(curr);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            
            level++;
        }
        
        return getLCA(root, nodes);
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public TreeNode getLCA(TreeNode root, List<TreeNode> nodes) {
        TreeNode res = null;
        for (TreeNode node: nodes) {
            res = getLCAHelper(root, res, node);
        }
        return res;
    }

    public TreeNode getLCAHelper(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.val == root.val || node2.val == root.val) return root;

        TreeNode left = getLCAHelper(root.left, node1, node2);
        TreeNode right = getLCAHelper(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}