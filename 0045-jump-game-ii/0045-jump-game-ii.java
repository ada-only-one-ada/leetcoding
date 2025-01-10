class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0; // 如果数组长度为1或更小，则不需要跳跃

        int steps = 0; // 跳跃次数
        int currFar = 0; // 当前步骤能达到的最远距离
        int nextFar = 0; // 下一步能达到的最远距离
        int i = 0; // 用来遍历数组

        // 我们不需要遍历最后一个元素，因为在达到最后一个元素之前就已经停止循环
        while (i < nums.length - 1) {
            // 更新下一步的最远距离
            nextFar = Math.max(nextFar, i + nums[i]);
            
            // 如果当前索引达到当前步的最远距离，我们需要进行一次新的跳跃
            if (i == currFar) {
                steps++; // 增加跳跃次数
                currFar = nextFar; // 更新当前最远距离

                // 如果当前最远距离已经可以到达或超过最后一个索引，直接返回跳跃次数
                if (currFar >= nums.length - 1) {
                    return steps;
                }
            }

            i++; // 继续遍历数组
        }

        return steps;
    }
}
