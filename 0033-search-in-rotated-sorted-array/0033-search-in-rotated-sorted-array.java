class Solution {
    public int search(int[] nums, int target) {
        int peakPos = findPeak(nums);
        if (nums[0] <= target && target <= nums[peakPos]){
            return binarySearch(nums, target, 0, peakPos);
        }
        return binarySearch(nums, target, peakPos, nums.length - 1);    
    }
    
    public int binarySearch(int[] nums, int target, int left, int right){
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    } 
    
    public int findPeak(int[] nums){
        if (nums.length == 1) return 0;
        if (nums[0] < nums[nums.length - 1]) return nums.length - 1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                return mid;
            }else if (nums[left] < nums[mid]){
                left = mid;
            }else if (nums[left] > nums[mid]){
                right = mid;
            }
        }
        if (nums[right] > nums[left]) return right;
        return left;    
    }
}