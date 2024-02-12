class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, new ArrayList<>(), new HashSet<>());
        return res;
    }

    public void backtracking(int[] nums,  List<List<Integer>> res, List<Integer> currRes, Set<Integer> set) {
        if (set.size() == nums.length) {
            res.add(new ArrayList<>(currRes));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) continue;

            currRes.add(nums[i]);
            set.add(i);

            backtracking(nums, res, currRes, set);

            currRes.remove(currRes.size() - 1);
            set.remove(i);
        }
        
    }
}