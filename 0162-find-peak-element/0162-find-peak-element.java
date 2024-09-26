class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int[] newNums = new int[nums.length + 2];
        newNums[0] = newNums[newNums.length - 1] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        nums = newNums;

        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
            
        } 

        return -1;
    }
}