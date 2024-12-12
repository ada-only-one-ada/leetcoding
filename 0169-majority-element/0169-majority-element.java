class Solution {
    public int majorityElement(int[] nums) {
        // O(n) time and O(1) space

        int candidate = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == -1) {
                    candidate = nums[i];
                    count = 0;
                }
            }
        }

        return candidate;
    }
}