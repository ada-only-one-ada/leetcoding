class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        int i = 0;
        int currEnd = 0;
        int nextEnd = 0;

        while (currEnd < nums.length - 1) {
            nextEnd = Math.max(nextEnd, nums[i] + i);

            if (i == currEnd) {
                if (nextEnd <= currEnd) return -1;

                currEnd = nextEnd;
                res++;
            }

            i++;
        }

        return res;
    }
}