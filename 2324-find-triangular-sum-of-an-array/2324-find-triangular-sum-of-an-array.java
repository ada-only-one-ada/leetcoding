class Solution {
    public int triangularSum(int[] nums) {
        return dfs(nums);
    }

    public int dfs(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] temp = new int[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            temp[i - 1] = (nums[i] + nums[i - 1]) % 10;
        }

        return dfs(temp);
    }
}