class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int start, List<Integer> currRes) {
        if (currRes.size() >= 2) {
            res.add(new ArrayList<>(currRes));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
           
            if (currRes.size() == 0 || nums[i] >= currRes.get(currRes.size() - 1)) {
                set.add(nums[i]);
                
                currRes.add(nums[i]);
                dfs(nums, i + 1, currRes);
                currRes.remove(currRes.size() - 1);
            }
        }
    }
}