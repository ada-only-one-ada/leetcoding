class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(root, targetSum, res, new ArrayList<>());
        return res;
    }

    public void backtracking(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> currRes) {
        if (root == null) return;
        
        currRes.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                res.add(new ArrayList<>(currRes));
            }
            currRes.remove(currRes.size() - 1);
            return;
        }

        backtracking(root.left, targetSum - root.val, res, currRes);
        backtracking(root.right, targetSum - root.val, res, currRes);
        currRes.remove(currRes.size() - 1);
    }
}