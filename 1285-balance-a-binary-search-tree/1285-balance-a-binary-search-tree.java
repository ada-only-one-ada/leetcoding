class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node);

                if (node.right != null) curr = node.right;
            }
        }

        return buildTree(list, 0, list.size() - 1);
    }

    public TreeNode buildTree(List<TreeNode> list, int start, int end) {
        if (start > end) return null;
        if (list.size() == 0) return null;
        if (list.size() == 1) return list.get(0);

        int midIndex = start + (end - start) / 2;
        TreeNode midRoot = list.get(midIndex);

        midRoot.left = buildTree(list, start, midIndex - 1);
        midRoot.right = buildTree(list, midIndex + 1, end);

        return midRoot;
    }
}