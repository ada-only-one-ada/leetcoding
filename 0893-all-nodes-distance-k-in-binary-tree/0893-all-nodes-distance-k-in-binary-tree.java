class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addParent(root, null);
        List<Integer> answer = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(target, k, answer, visited);

        return answer;
    }

    private void addParent(TreeNode cur, TreeNode parent) {
        if (cur != null) {
            this.parent.put(cur, parent);
            addParent(cur.left, cur);
            addParent(cur.right, cur);
        }
    }

    private void dfs(TreeNode cur, int distance, List<Integer> answer, Set<TreeNode> visited) {
        if (cur == null || visited.contains(cur)) {
            return;
        }

        visited.add(cur);
        if (distance == 0) {
            answer.add(cur.val);
            return;
        }

        dfs(parent.get(cur), distance - 1, answer, visited);
        dfs(cur.left, distance - 1, answer, visited);
        dfs(cur.right, distance - 1, answer, visited);
    }
}