class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preRootIndex, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        if (preRootIndex < 0 || preRootIndex >= preorder.length) return null;

        int rootValue = preorder[preRootIndex];
        int inRootIndex = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, preRootIndex + 1, inorder, inStart, inRootIndex - 1);
        // 注意判断左子树的节点数量，需要减去 inStart，而不是仅仅用 inRootIndex - 0 判断
        root.right = helper(preorder, preRootIndex + 1 + (inRootIndex - inStart), inorder, inRootIndex + 1, inEnd);

        return root;
    }
}
/*
preorder: root, left, right 
inorder: left, root, right
*/