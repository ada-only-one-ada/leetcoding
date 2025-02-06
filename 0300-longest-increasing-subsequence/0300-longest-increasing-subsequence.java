class Solution {
    public int lengthOfLIS(int[] nums) {
        int piles = 0;
        int[]top = new int[nums.length];

        for (int num: nums) {
            int left = 0;
            int right = piles;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (num > top[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == piles) {
                piles++;
            }
            top[left] = num;
        }

        return piles;
    }
}