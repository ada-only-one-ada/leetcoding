class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;

        for (int num: nums) {
            int left = 0;
            int right = piles;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (num <= top[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            top[left] = num;
            if (left == piles) piles++;
        }

        return piles;
    }
}