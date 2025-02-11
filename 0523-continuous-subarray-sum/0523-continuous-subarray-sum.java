class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
      
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
          
            if (i >= 2) {
                set.add(prefix[i-2] % k);
            }

            if (set.contains(prefix[i] % k)) {
                return true;
            }
        }

        return false;
    }
}