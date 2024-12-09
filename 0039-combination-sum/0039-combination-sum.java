class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtracking(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int index, List<Integer> currRes, int sum) {
        if (index == candidates.length || sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(currRes));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            currRes.add(candidates[i]);

            backtracking(candidates, target, i, currRes, sum);

            sum -= candidates[i];
            currRes.remove(currRes.size() - 1);
        }
    }
}