class Solution {
    public int getLargestOutlier(int[] nums) {
        /* 
        Hint: What will be the value of array sum if we remove the outlier from it?
        [x, y, z, x+y+z, outlier]，去掉outlier，整个数组的和就是 2(x+y+z)
        比如，[-2,-1,-3,-6,4]，去掉4，[-2,-1,-3,-6]，sum is -12

        edge case: [8,1,-8,-3,6], Expected: -8, Output: 1
        */

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] * 2, i); // 这里为了避免后面需要处理有余数的情况
            sum += nums[i];
        }
        
        int maxOutlier = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int doubleSum = sum - nums[i];
            if (map.containsKey(doubleSum) && map.get(doubleSum) != i) {
                maxOutlier = Math.max(maxOutlier, nums[i]);
            }
        }

        return maxOutlier;
    }
}