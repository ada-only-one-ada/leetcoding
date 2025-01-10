class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) return 0; // 如果数组长度为0，直接返回0（虽然题目默认至少有一个元素）
        int res = 0;
        
        int currentStart = 0;
        int currentEnd = 0;
        int nextEnd = 0;
        
        // 遍历数组中的元素来计算跳跃步数，除了最后一个元素
        while (currentEnd < nums.length - 1) {
            // 遍历当前可以覆盖的范围
            for (int index = currentStart; index <= currentEnd; index++) {
                // 更新下一次跳跃可以达到的最远距离
                nextEnd = Math.max(index + nums[index], nextEnd);
            }

            // 更新下一次的起始位置为当前覆盖范围的下一个位置
            currentStart = currentEnd + 1;
            // 完成一次跳跃，跳跃次数增加
            res++;
            // 更新当前覆盖的最远范围为下一次可以到达的最远范围
            currentEnd = nextEnd;
        }

        return res;
    }
}
