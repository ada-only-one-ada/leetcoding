class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int currHeight) {
        if (root == null) return;

        if (currHeight == res.size()) {
            res.add(root.val);
        }

        // 首先尝试遍历右子树
        if (root.right != null) {
            dfs(root.right, currHeight + 1);
        } 
        
        // 再尝试遍历左子树
        if (root.left != null ) {
            dfs(root.left, currHeight + 1);
        }

        
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}