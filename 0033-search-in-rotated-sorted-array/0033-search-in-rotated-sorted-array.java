class Solution {
    public int search(int[] nums, int target) {        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }

            /* normal binary search 
            if (nums[left] < nums[right]){
                if (nums[mid] < target){
                    left = mid;
                }else if (nums[mid] > target){
                    right = mid;
                }
            }
            */

            // rotated binary search 
            // mid to right: increasing
            if (nums[mid] < nums[right]){
                if (nums[mid] < target && target <= nums[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }

            // left to mid: increasing
            if (nums[left] < nums[mid]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid;
                }else{
                    left = mid;
                }
            }
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}