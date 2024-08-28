class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap();
        Set<Integer> children = new HashSet<>();

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

        TreeNode root = null;
        for (int val: nodes.keySet()) {
            if (!children.contains(val)) {
                root = nodes.get(val);
                return root;
            }
        }

        return null;
    }
}