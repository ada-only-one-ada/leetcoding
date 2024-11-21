class Solution {
    Map<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // preorder：根-左-右
        // postorder：左-右-根

        map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return helper(preorder, 0, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int[] postorder, int postStart, int postEnd) {
        if (preStart == preorder.length || postStart > postEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        // 如果这是最后一个节点，没有左或右子树
        if (preStart == preorder.length - 1 || postStart == postEnd) {
            return root; 
        }

        int leftVal = preorder[preStart + 1]; // 根-左
        int leftIndex = map.get(leftVal); // 找到postorder里面左的位置
        int leftSize = leftIndex - postStart + 1; // 计算左子树一共有几个孩子

        root.left = helper(preorder, preStart + 1, postorder, postStart, leftIndex); 
        root.right = helper(preorder, preStart + leftSize + 1, postorder, leftIndex + 1, postEnd - 1);

        return root;
    }
}