class Solution {
    Map<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // preorder：根 左 右
        // postorder：左 右 根

        map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        // 如果这两个索引相等，意味着在这个递归的子任务中，只考虑 preorder 数组中的一个元素
        // 这个元素是当前子树的根节点，并且由于没有其他元素，说明这个根节点没有左子树或右子树
        if (preStart == preEnd) return root; 

        int leftVal = preorder[preStart + 1]; // 根-左
        int leftIndex = map.get(leftVal); // 找到postorder里面左的位置
        int leftSize = leftIndex - postStart + 1; // 计算左子树一共有几个孩子

        // 这里postEnd要包括leftIndex因为它是左子树最后一个孩子
        root.left = helper(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftIndex); 
        root.right = helper(preorder, preStart + leftSize + 1 , preEnd, postorder, leftIndex + 1, postEnd - 1);

        return root;
    }
}