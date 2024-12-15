class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 1;
        
        //     nums = [1,2,3,4]
        // prefix = [1,1,2,6,24]
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        //           0 1 2 3  4
        // prefix = [1,1,2,6,24]
        //              0 1 2 3
        //      nums = [1,2,3,4]
        //                       1
                      
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            nums[i] = suffix * prefix[i];
            suffix *= num;
        }

        return nums;
    }
}