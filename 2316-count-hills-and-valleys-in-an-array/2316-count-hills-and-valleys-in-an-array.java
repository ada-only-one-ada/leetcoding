class Solution {
    public int countHillValley(int[] nums) {
        boolean prevIncreasing = false;
        boolean prevDecreasing = false;

        int res = 0;

        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] > nums[i - 1]) {
                if (prevDecreasing) {
                    res++;
                }
                prevIncreasing = true;
                prevDecreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                if (prevIncreasing) {
                    res++;
                }
                prevDecreasing = true;
                prevIncreasing = false;
            }
        }
        return res;
    }
}