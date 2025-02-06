class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums[nums.length - 1] - nums[0] + 1;
        int res = 0;

        while (start < end) {
            int maxDistance = start + (end - start) / 2;

            if (countPairsLessThan(nums, maxDistance) >= k) {
                res = maxDistance;
                end = maxDistance;
            } else {
                start = maxDistance + 1;
            }
        }

        return res;
    }

    public int countPairsLessThan(int[] nums, int maxDistance) {
        int count = 0;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (i < nums.length && nums[j] - nums[i] > maxDistance) {
                i++;
            }

            count += j - i;
        }

        return count;
    }
}