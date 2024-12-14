class Solution {
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root, new ArrayList<>());
        return min;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;

        dfs(root.left, list);
        if (list.size() > 0) {
            min = Math.min(min, root.val - list.get(list.size() - 1));
        }
        list.add(root.val);
        dfs(root.right, list);
    }
}