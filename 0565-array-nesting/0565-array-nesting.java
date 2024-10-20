class Solution {
    int res = 0;
    public int arrayNesting(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            // 只从没访问过的开始
            if (nums[index] != -1) {
                dfs(nums, index, 0);
            }
        }

        return res;
    }

    public void dfs(int[] nums, int index, int len) {
        // 超出边界，或者已经被访问过了，更新结果，返回
        if (index < 0 || index >= nums.length || nums[index] == -1) {
            res = Math.max(res, len);
            return;
        } 

        // temp 存起来
        int nextIndex = nums[index];
        //标记已访问
        nums[index] = -1;
        dfs(nums, nextIndex, len + 1);
    }
}