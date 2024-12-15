class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] bucket = new int[20001];

        for (int num: nums) {
            bucket[num + 10000]++;
        }

        for (int i = bucket.length - 1; i >= 0; i--) {
            k -= bucket[i];

            if (k <= 0) {
                return i - 10000;
            }
        }

        return -1;
    }
}