class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
       
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
          
            if (sum[i] == k) count++;
           
            for (int j = 1; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
