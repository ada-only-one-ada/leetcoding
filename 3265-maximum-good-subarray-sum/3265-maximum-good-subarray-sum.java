class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = Long.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
            
            if (map.containsKey(nums[i] - k)) {
                long subarraySum = prefixSum[i] - prefixSum[map.get(nums[i] - k)] + nums[map.get(nums[i] - k)];
                res = Math.max(res, subarraySum);
            } 
            
            if (map.containsKey(nums[i] + k)) {
                long subarraySum = prefixSum[i] - prefixSum[map.get(nums[i] + k)] + nums[map.get(nums[i] + k)];
                res = Math.max(res, subarraySum);
            }

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (nums[i] >= prefixSum[i] - prefixSum[map.get(nums[i])] + nums[map.get(nums[i])]) {
                    map.put(nums[i], i);
                }
            }
        }

        return res == Long.MIN_VALUE? 0: res;
    }
}