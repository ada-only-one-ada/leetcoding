class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int doubleSum = sum - nums[i];
            int target = doubleSum / 2;

            if (map.containsKey(target) && doubleSum % 2 == 0) {
                if (target == nums[i]) {
                    if (map.get(target) == 1) continue;
                }
                max = Math.max(max, nums[i]);
            }
        }

        return max;
    }
}