class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while (right < nums.length){
            if (nums[right] == 0){
                right++;
            }else if (nums[right] != 0){
                nums[left] = nums[right];
                left++;
                right++;
            }
        }

        for (int i = left; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}