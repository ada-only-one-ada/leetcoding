class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> currRes, int currSum, int index) {
        // 所有数字都是正数
        if (currSum >= target) {
            if (currSum == target) {
                res.add(new ArrayList<>(currRes));
            }
            return;
        }

        // 注意读题，每个数字可以拿无数遍
        for (int i = index; i < candidates.length; i++) {
            currRes.add(candidates[i]);
            currSum += candidates[i];
            backtracking(candidates, target, res, currRes, currSum, i);
            currRes.remove(currRes.size() - 1);
            currSum -= candidates[i];
        }
    }
}