class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int res = Integer.MAX_VALUE;

        for (int len = l; len <= r; len++) {
            res = Math.min(res, helper(nums, len));
        }

        return res == Integer.MAX_VALUE? - 1 : res;
    }

    public int helper(List<Integer> nums, int len) {
        int res = Integer.MAX_VALUE;

        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); right++) {
            sum += nums.get(right);

            if (right - left + 1 == len) {
                if (sum > 0) res = Math.min(res, sum);
                sum -= nums.get(left);
                left++;
            }
        }

        return res;
    }
}