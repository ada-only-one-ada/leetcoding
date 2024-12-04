class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] freq = new int[20001];
        int offset = 10000;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freq[num + offset]++;
            max = Math.max(max, num + offset);
        }

        for (int i = max; i >= 0; i--) {
            if (freq[i] == 0) continue;
            k -= freq[i];
            if (k <= 0) return i - offset;
        }

        return -1;
    }
}