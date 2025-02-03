class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        dfs(root, 1);
        return res;    
    }

    public void dfs(TreeNode root, int level) {
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }

        res.get(level - 1).add(root.val);
        if (root.left != null) dfs(root.left, level + 1);
        if (root.right != null) dfs(root.right, level + 1);
    }
}