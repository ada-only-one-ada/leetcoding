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
            
            // [6,-31,50,-35,41,37,-42,13], output: 13, Expected: -35
            // sum = 39
            // 假设最后一个数字13是outlier, (39-13)/2 = 13, 这里是错的, 有一个sum存在, 不能是outlier同一个index
            if (remain == 0 && map.containsKey(currSum) && map.get(currSum) != i) {
                maxOutlier = Math.max(maxOutlier, nums[i]);
            }
        }

        return maxOutlier;
    }
}