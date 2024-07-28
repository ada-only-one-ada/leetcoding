class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        
        prefix[0] = 1;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i-1];
        }

        int postsum = 1;
        for (int i = prefix.length - 1; i >= 0; i--) {
            prefix[i] = prefix[i] * postsum;
            postsum = postsum * nums[i];
        }

        return prefix;
    }
}