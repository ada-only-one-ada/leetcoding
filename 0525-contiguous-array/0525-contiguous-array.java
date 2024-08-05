class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // [0, 1, 1], [0, 1]
        int maxLen = 0;

        
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                prefixSum--;
            } else if (nums[i] == 1) {
                prefixSum++;
            }

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            } 
        }

        return maxLen;
    }
}