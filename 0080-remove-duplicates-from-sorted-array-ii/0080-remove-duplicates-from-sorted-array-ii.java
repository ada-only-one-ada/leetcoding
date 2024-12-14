class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int replaceIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[replaceIndex-1] || nums[i] != nums[replaceIndex-2]) {
                nums[replaceIndex++] = nums[i];
            } 
        }
        return replaceIndex;
    }
}