class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long)n * (n - 1) / 2; // long

        // nums[j] - j = nums[i] - i

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = nums[i] - i;
            map.put(curr, map.getOrDefault(curr, 0L) + 1); // OL
        } 

        long goodPairs = 0;
        for (long freq: map.values()) {
            goodPairs += (freq) * (freq - 1) / 2;
        }

        return totalPairs - goodPairs;
    }
}