class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 两个相同的数字，位置距离小于等于k

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}