class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;  // 如果数组长度为1或更少，则不需要任何跳跃
        
        int res = 0;  // 用来记录跳跃次数
        int currEnd = 0;  // 当前跳能达到的最远位置
        int nextEnd = 0;  // 下一跳能达到的最远位置
        int i = 0;  // 数组索引，用于遍历数组

        // 循环条件是当前最远位置小于数组最后一个元素的索引
        while (currEnd < nums.length - 1) {
            // 更新下一跳能达到的最远位置
            nextEnd = Math.max(nextEnd, i + nums[i]);

            // 如果遍历到了当前跳的边界
            if (i == currEnd) {
                // 如果当前位置等于下一位置，且当前位置不是数组末尾，则无法到达数组末尾
                if (currEnd == nextEnd) {
                    return -1;  // 返回-1表示无法到达末尾
                }
                // 完成一次跳跃，更新跳数和当前跳的最远位置
                res++;
                currEnd = nextEnd;
            }
            // 移动索引，继续向前探索
            i++;
        }
        
        return res;  // 返回需要的最小跳跃次数
    }
}
