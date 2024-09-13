class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        long res = 0;
        int start = 0;
        long pairCount = 0; // This will track the number of valid pairs in the current window

        for (int end = 0; end < nums.length; end++) {
            int num = nums[end];
            // If this number has appeared before, it can form new pairs with each of its previous appearances
            if (count.containsKey(num)) {
                pairCount += count.get(num);
            }

            // Include this number in the count
            count.put(num, count.getOrDefault(num, 0) + 1);

            // Check if the current number of pairs is at least k
            while (pairCount >= k) {
                // All subarrays starting from 'start' to 'end' and ending at 'end' to 'nums.length - 1' are valid
                res += nums.length - end; 
                // Move the start forward, reducing count of the start element
                count.put(nums[start], count.get(nums[start]) - 1); 
                // Reduce the pairs count as we're removing one occurrence of nums[start]
                pairCount -= count.get(nums[start]); 
                start++;
            }
        }

        return res;
    }
}