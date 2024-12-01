class Solution {
    public int getLargestOutlier(int[] nums) {
        // [x, y, z, x+y+z, outlier]
        // 去掉outlier，整个数组的和就是 2(x+y+z)

        // [-2,-1,-3,-6,4]
        // [-2,-1,-3,-6] sum is -12

        // edge case: [8,1,-8,-3,6], Expected: -8, Output: 1

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] * 2, i);
            sum += nums[i];
        }
        
        int maxOutlier = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((sum - nums[i])) && map.get(sum - nums[i]) != i) {
                maxOutlier = Math.max(maxOutlier, nums[i]);
            }
        }

        return maxOutlier;
    }
}