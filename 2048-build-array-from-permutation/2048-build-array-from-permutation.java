class Solution {
    public int[] buildArray(int[] nums) {
        // [5,       0,     1,     2,     3,     4]
        //  4005    5000    1      1002   2003   3004
         
        // [4,5,0,1,2,3]

        for (int i = 0; i < nums.length; i++) {
            int targetIndex = nums[i];
            int targetNum = nums[targetIndex];

            nums[i] = 1000 * (targetNum % 1000) + nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }

        return nums;
    }
}