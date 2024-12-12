class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];

        int diff = 0;
        for (int num: nums) {
            if (num == candidate) {
                diff++;
            } else {
                diff--;
                if (diff == -1) {
                    candidate = num;
                    diff = 0;
                }
            }
        }

        return candidate;
    }
}