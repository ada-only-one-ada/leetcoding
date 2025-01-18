class Solution {
    public int triangularSum(int[] nums) {
        return dfs(nums);
    }

    public int dfs(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] temp = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            temp[i] = (nums[i] + nums[i + 1]) % 10;
        }

        return dfs(temp);
    }
}