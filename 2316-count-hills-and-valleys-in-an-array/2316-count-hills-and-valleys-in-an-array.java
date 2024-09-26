class Solution {
    public int countHillValley(int[] nums) {
        // 两个variable记录之前山峰的状态
        boolean prevIncrease = false;
        boolean prevDecrease = false;

        int res = 0;

        // 不用考虑等于的情况，因为等于的情况，这两个variable都不会更新
        for (int i = 1; i < nums.length ; i++) {
            // 现在是上升的
            if (nums[i] > nums[i - 1]) {
                // 之前是下降的
                if (prevDecrease) {
                    // 说明前一个是低谷
                    res++;
                }
                // 更新状态
                prevIncrease = true;
                prevDecrease = false;
            // 现在是下降的
            } else if (nums[i] < nums[i - 1]) {
                // 之前是上升的
                if (prevIncrease) {
                    // 说明前一个是山顶
                    res++;
                }
                // 更新状态
                prevDecrease = true;
                prevIncrease = false;
            }
        }
        return res;
    }
}