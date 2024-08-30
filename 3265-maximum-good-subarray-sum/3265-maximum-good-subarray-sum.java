class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = Long.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        long[] prefixSum = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = nums[0];
            } else {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
            
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, prefixSum[i] - prefixSum[map.get(nums[i] - k)] + nums[map.get(nums[i] - k)]);
            } 
            
            if (map.containsKey(nums[i] + k)) {
                res = Math.max(res, prefixSum[i] - prefixSum[map.get(nums[i] + k)] + nums[map.get(nums[i] + k)]);
            }

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (nums[i] >= prefixSum[i] - prefixSum[map.get(nums[i])] + nums[map.get(nums[i])]) {
                    map.put(nums[i], i);
                }
            }
        }

        if (res == Long.MIN_VALUE) return 0;
        return res;
    }
}