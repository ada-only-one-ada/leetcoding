class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        int ans = 0;
        int leftCnt = 1;
        while(right < n){
            sum += nums[right];
            if(sum > goal) {
                leftCnt = 1;
            }
            while(sum > goal && left < right){
                sum -= nums[left++];
            }
            while(sum == goal && left < right && nums[left] == 0){
                leftCnt++;
                left++;
            }
            if(sum == goal) ans += leftCnt;
            right++;
        }
        return ans;
    }
}
