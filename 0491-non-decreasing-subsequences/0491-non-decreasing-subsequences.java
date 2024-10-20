class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, new ArrayList<>(), 0);
        return res;
    }

    public void backtracking(int[] nums, List<Integer> currRes, int start) {
        if (currRes.size() >= 2) {
            res.add(new ArrayList<>(currRes));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;

            if (currRes.size() == 0 || (nums[i] >= currRes.get(currRes.size() - 1))){
                currRes.add(nums[i]);
                set.add(nums[i]);

                backtracking(nums, currRes, i + 1);

                currRes.remove(currRes.size() - 1);
            }        
        }
    }
}