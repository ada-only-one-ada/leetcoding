class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> currRes: res) {
            list.add(currRes);
        }
        return list;
    }

    public void backtracking(int[] nums, int start, List<Integer> currRes) {
        if (currRes.size() >= 2) {
            res.add(new ArrayList<>(currRes));

            // if (start == nums.length) return; 上面这行没有nums[start] optional
        }

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && currRes.size() == 0) continue;
            if (currRes.size() == 0 || nums[i] >= currRes.get(currRes.size() - 1)) {
                currRes.add(nums[i]);
                backtracking(nums, i + 1, currRes);
                currRes.remove(currRes.size() - 1); // 不一定要接着这个数字
            }
        }
    }
}