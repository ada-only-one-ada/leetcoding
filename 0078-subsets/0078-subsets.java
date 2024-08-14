class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtracking(int[] nums, List<List<Integer>> res, List<Integer> currRes, int start) {
        res.add(new ArrayList<>(currRes));

        if (start == nums.length) return;
        for (int i = start; i < nums.length; i++) {
            currRes.add(nums[i]);
            backtracking(nums, res, currRes, i + 1);
            currRes.remove(currRes.size() - 1);
        }
    }
}