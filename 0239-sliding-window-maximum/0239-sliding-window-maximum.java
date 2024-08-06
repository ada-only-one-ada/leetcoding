class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek()[1] + k <= i) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[i] > queue.peek()[0]) {
                queue.poll();
            }

            queue.add(new int[]{nums[i], i});

            if (i >= k - 1) {
                res[index++] = queue.peek()[0];
            }
        }
        
        return res;
    }
}