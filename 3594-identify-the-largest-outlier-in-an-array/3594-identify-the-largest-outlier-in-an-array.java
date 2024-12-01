class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); 
            sum += nums[i];
        }
        
        int maxOutlier = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currSum = (sum - nums[i]) / 2;
            int remain = (sum - nums[i]) % 2;

            if (remain == 0 && map.containsKey(currSum) && map.get(currSum) != i) {
                maxOutlier = Math.max(maxOutlier, nums[i]);
            }
        }

        return maxOutlier;
    }
}