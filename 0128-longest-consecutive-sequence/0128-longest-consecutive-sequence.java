class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0; 

        Arrays.sort(nums);

        int longestLen = 1;
        int currLen = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]) continue;   
           
            if (nums[i] == nums[i - 1] + 1){
                currLen++;
            } else{
                longestLen = Math.max(longestLen, currLen);
                currLen = 1;
            }
        }

        return Math.max(longestLen, currLen);
    }
}