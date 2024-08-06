class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && i - queue.peek()[0] >= k) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[i] > queue.getLast()[1]) {
                queue.removeLast();
            }  

            queue.add(new int[]{i, nums[i]});
            if (i >= k-1) {
                res[index++] = queue.getFirst()[1];
            }
        }

        return res;
    }
}