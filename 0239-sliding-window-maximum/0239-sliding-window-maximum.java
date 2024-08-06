class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && i - queue.peek()[0] >= k) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[i] > queue.peek()[1]) {
                queue.poll();
            }

            queue.add(new int[]{i, nums[i]});

            if (i >= k - 1) {
                res[index++] = queue.peek()[1];
            }
        }
        
        return res;
    }
}