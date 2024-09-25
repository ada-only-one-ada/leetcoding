class Solution {
    public int findKthLargest(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int num: nums) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        int[] count = new int[maxValue - minValue + 1];
        for (int num: nums) {
            count[num - minValue]++;
        }

        for (int num = count.length - 1; num >= 0; num--) {
            if (count[num] == 0) continue;

            k -= count[num];
            if (k <= 0) {
                return num + minValue;
            }
        }

        return -1;
    }
}