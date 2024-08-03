class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> currRes, int sum, int index) {
        if (sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(currRes));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            currRes.add(candidates[i]);
            sum += candidates[i];
            // i可以再取，但不可以往前取，所以start记录从每次开始的位置
            backtracking(candidates, target, res, currRes, sum, i);
            currRes.remove(currRes.size() - 1);
            sum -= candidates[i];
        }
    }
}