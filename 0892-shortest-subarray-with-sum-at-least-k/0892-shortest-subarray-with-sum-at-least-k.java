class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int res = nums.length + 1; // an impossible value as res

        long[] prefixSum = new long[nums.length + 1];
        //         nums = [2, -1, 2]
        // prefixSum = [0, 2, 1, 3]
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int end = 0; end < prefixSum.length; end++) {
            while (!queue.isEmpty() && prefixSum[end] - prefixSum[queue.getFirst()] >= k) {
                res = Math.min(res, end - queue.pollFirst());
            }

            while (!queue.isEmpty() && prefixSum[end] <= prefixSum[queue.getLast()]) {
                queue.pollLast();
            }

            queue.addLast(end);
        }

        if (res == nums.length + 1) return -1;
        return res;
    }
}