class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // [1, 3, 6]

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < prefixSum.length; i++) {
            if (map.containsKey(prefixSum[i] - k)) {
                res += map.get(prefixSum[i] - k);
            }

            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }

        return res;
    }
}