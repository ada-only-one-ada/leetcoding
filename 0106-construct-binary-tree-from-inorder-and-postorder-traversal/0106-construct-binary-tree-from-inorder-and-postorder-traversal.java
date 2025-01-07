class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
        inorder: left, root, right
        postorder: left, right, root
        */
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postRootIndex) {
        if (inStart > inEnd || postRootIndex < 0) return null;

        int rootValue = postorder[postRootIndex];
        int inRootIndex = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);
        root.left = helper(inorder, inStart, inRootIndex - 1, postorder, postRootIndex - 1 - (inEnd- inRootIndex));
        root.right = helper(inorder, inRootIndex + 1, inEnd, postorder, postRootIndex - 1);

        return root;
    }
}