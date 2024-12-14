
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right){
            int mid = left + (right-left)/2;
            if (nums[mid] >= target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid;
            }
        }

        if (target > nums[right]) return right + 1;
        if (target > nums[left]) return left + 1;
        if (target <= nums[left]) return left;
        return -1;
    }
}
/*
1. <=left, return left;
if (target == nums[left]) return left;
if (target < nums[left]) return left;

2. >right, return right+1
if (target > nums[right]) return right + 1;
       
3.==right, or left < target < right, return left+1
if (target == nums[right]) return right;
return left + 1;
*/