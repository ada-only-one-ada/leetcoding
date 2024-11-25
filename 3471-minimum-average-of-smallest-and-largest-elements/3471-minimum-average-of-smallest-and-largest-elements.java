class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            res = Math.min(res, (nums[i] + nums[j]));
            i++;
            j--;
        }

        return (double)res / 2;
    }
}