class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int currFar = 0;
        int nextFar = 0;

        int res = 1;
        for (int i = 0; i <= currFar; i++) {
            nextFar = Math.max(nextFar, nums[i] + i);

            if (nextFar >= nums.length - 1) {
                return res;
            }

            if (i == currFar) {
                if (nextFar == currFar) return -1;
                res++;
                currFar = nextFar;
            }
        }

        return res;
    }
}