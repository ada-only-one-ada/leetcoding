class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] bucket = new int[20001];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            bucket[num + 10000]++;
            max = Math.max(max, num + 10000);
            min = Math.min(min, num + 10000);
        }

        for (int i = max; i >= min; i--) {
            k -= bucket[i];

            if (k <= 0) {
                return i - 10000;
            }
        }

        return -1;
    }
}