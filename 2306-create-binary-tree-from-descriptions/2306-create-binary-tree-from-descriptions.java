class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap();
        Set<Integer> children = new HashSet<>();

        // Step 1: Create all nodes and record the children
        for (int[] desc: descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            nodes.putIfAbsent(parent, new TreeNode(parent));
            nodes.putIfAbsent(child, new TreeNode(child));

            if (isLeft) {
                nodes.get(parent).left = nodes.get(child);
            } else {
                nodes.get(parent).right = nodes.get(child);
            }

            children.add(child);
        }

        // Step 2: Find the root (a node that is never a child)
        TreeNode root;
        for (int val: nodes.keySet()) {
            if (!children.contains(val)) {
                root = nodes.get(val);
                return root;
            }
        }

        return null;
    }
}