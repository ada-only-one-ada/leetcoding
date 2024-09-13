class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        
        // This will track the number of valid pairs in the current window
        long pairs = 0; 

        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            int num = nums[end];
            // If this number has appeared before, it can form new pairs with each of its previous appearances
            pairs += map.getOrDefault(num, 0);
            

            // Include this number in the count
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Check if the current number of pairs is at least k
            while (pairs >= k) {
                // All subarrays starting from 'start' to 'end' and ending at 'end' to 'nums.length - 1' are valid
                res += nums.length - end; 
                // Move the start forward, reducing count of the start element
                map.put(nums[start], map.get(nums[start]) - 1); 
                // Reduce the pairs count as we're removing one occurrence of nums[start]
                pairs -= map.get(nums[start]); 
                start++;
            }
        }

        return res;
    }
}