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

            while (!dequeue.isEmpty() && prefixSum[end] <= prefixSum[dequeue.getLast()]) {
                dequeue.pollLast();
            }

            dequeue.addLast(end);
        }

        if (res == nums.length + 1) return -1;
        return res;
    }
}