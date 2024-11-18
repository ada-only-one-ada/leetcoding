class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int res = nums.length + 1;

        // long 防止溢出
        long[] prefixSum = new long[nums.length + 1];
        //         nums = [1, 4, 5]
        // prefixSum = [0, 1, 5, 9]
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        Deque<Integer> dequeue = new ArrayDeque<>();
        // loop over the prefixSum array
        for (int end = 0; end < prefixSum.length; end++) {
            // 如果queue里面有startIndex，且[start, end]之和大于等于k
            // 我们可以不断缩进更新结果，看有没有更短的结果
            //                  0  1  2  3
            // 比如 prefixSum = [0, 1, 5, 9]， k = 5，现在 end 是2，deque是[0, 1]
            //  5 - 0 = 5 >= k, update resule 
            //  5 - 1 < k, not satisfy, exit loop
            while (!dequeue.isEmpty() && prefixSum[end] - prefixSum[dequeue.getFirst()] >= k) {
                res = Math.min(res, end - dequeue.pollFirst());
            }

            // 如果当前索引 end 的前缀和 prefixSum[end] 比队列中最后一个索引的前缀和小或者相等，
            // 那么从这个队尾索引开始到 end 的子数组的和会是负数或零。
            // 这意味着，如果我们从队尾索引开始的子数组和已经不能满足条件 ≥k，
            // 那么从任何比这个队尾索引还要早的位置开始的子数组都不可能满足条件。
            // 因此，继续保持这个更大的前缀和没有意义，因为从更早的位置开始的子数组只会更长，
            // 而且不会帮助我们找到满足条件的更短子数组。
            while (!dequeue.isEmpty() && prefixSum[end] <= prefixSum[dequeue.getLast()]) {
                dequeue.pollLast();
            }

            // 把当前 index 作为 startIndex 加入 queue
            dequeue.addLast(end);
        }

        if (res == nums.length + 1) return -1;
        return res;
    }
}