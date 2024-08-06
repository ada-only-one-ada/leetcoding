class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值
            // 队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            if (!queue.isEmpty() && i - queue.peekFirst() == k){
                queue.pollFirst();
            }
            
            // 既然是单调，就要保证每次放进去的数字要比末尾(curr window res)的大，否则也弹出
            //  if (!queue.isEmpty() && queue.peekFirst() < i - k + 1)
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                 queue.pollLast();
            }

            queue.offer(i);

            if (i >= k - 1) {
                res[index] = nums[queue.peekFirst()];
                index++;
            }
        }
        
        return res;
    }
}