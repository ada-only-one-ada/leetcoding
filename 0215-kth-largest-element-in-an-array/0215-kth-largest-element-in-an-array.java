class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 10000
        int[] freq = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i] + 10000;

            freq[number]++;
        }

        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] == 0) continue;
            k -= freq[i];

            if (k <= 0) return i - 10000;
        }

        return -1;
    }
}