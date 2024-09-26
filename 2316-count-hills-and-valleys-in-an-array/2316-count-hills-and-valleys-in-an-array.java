class Solution {
    public int countHillValley(int[] nums) {
        // 0：初始
        // 1: 上升
        // -1: 下降
        int prev = 0;
        int res = 0;

        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] > nums[i - 1]) {
                if (prev == -1) {
                    res++;
                }
                prev = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (prev == 1) {
                    res++;
                }
                prev = -1;
            }
        }
        return res;
    }
}