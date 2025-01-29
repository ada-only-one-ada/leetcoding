class Solution {
    public int minimumOperations(int[] nums) {
        // 选择小于等于nums里非0的最小数
        // [0, 1, 3, 5, 5]
        int res = 0;
        Arrays.sort(nums);

        // 之前减去的数要累加，因为每次减法影响都是累积的
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - prev;
            if (nums[i] <= 0) continue;
           
            prev += nums[i];
            res++;
        }

        return res;
    }
}