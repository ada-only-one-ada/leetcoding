class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && i - queue.peek()[0] >= k) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[i] > queue.getLast()[1]) {
                queue.removeLast();
            }  

            int[] curr = new int[]{i, nums[i]};
            queue.add(curr);
            if (i >= k-1) {
                res[index++] = queue.getFirst()[1];
            }
        }
        
        return res;
    }
}