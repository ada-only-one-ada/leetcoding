class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num: nums) {
            queue.add(num);

            while (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}