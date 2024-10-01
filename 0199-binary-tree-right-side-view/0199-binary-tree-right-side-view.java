class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode curr, List<Integer> result, int depth) {
        if (curr == null) return;
        
        // 只有当到达一个新的层级时才添加
        if (depth == result.size()) {
            result.add(curr.val);
        }
        
        // 先右后左地递归
        dfs(curr.right, result, depth + 1);
        dfs(curr.left, result, depth + 1);
    }
}
