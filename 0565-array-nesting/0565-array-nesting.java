class Solution {
    int res = 0;
    public int arrayNesting(int[] nums) {
        // A global set shared by all dfs() calls to avoid TLE.
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, set, 1);
        }
        return res;
    } 

    public void dfs(int[] nums, int index, Set<Integer> set, int len) {
        if (index < 0 || index >= nums.length || index == nums[index] || set.contains(nums[index])) {
            res = Math.max(res, len);
            return;
        }

        set.add(index);
        dfs(nums, nums[index], set, len + 1);
    }
}