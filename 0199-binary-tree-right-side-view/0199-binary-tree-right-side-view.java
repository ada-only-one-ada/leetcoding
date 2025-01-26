class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 1);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;

        if (res.size() < level) {
            res.add(root.val);
        }

        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
    }
}