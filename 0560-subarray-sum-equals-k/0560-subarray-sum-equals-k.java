class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        if (sum[0] == k) count++;
       
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
           
            if (sum[i] == k) count++;
           
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}