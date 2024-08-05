class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 
        // [1,1,1],
        // prefixSum分别是 1，2，3
        // 要找 -1，0，1 （要减去的前缀和区间）
        // 比如当前prefixSum是3，我们要去掉前缀和为1的区间

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}