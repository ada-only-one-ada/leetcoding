class Solution {
    public int jump(int[] nums) {
        // 起点就是最后一个，不用跳跃，直接返回
        if (nums.length <= 1) return 0;

        int res = 0;

        int i = 0;
        int currEnd = 0;
        int nextEnd = 0;

        // 遍历当终点在最后一个之前
        while (currEnd < nums.length - 1) {
            // 当前能走的最远的距离
            nextEnd = Math.max(nextEnd, nums[i] + i);

            // 最到了当前能走的最远距离
            if (i == currEnd) {
                // 跳到了最后一个
                if (currEnd >= nums.length - 1) return res;

                // 下一个更远的不比当前的更远，结束遍历
                if (nextEnd <= currEnd) {
                    return -1;
                }

                res++;
                currEnd = nextEnd;
            }

            i++;
        }

        return res;
    }
}