class Solution {
    public int[] buildArray(int[] nums) {    
        // [5, 0, 1, 2, 3, 4]
        //  4.5? 比如是Integer，如何存
        // 4*1000 + 5 = 4005
        for (int i = 0; i < nums.length; i++) {
            int initNum = nums[i];
            int targetNum = nums[nums[i]] % 1000; 

            nums[i] = targetNum * 1000 + initNum;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / 1000;
        }
        
        return nums;
    }
}