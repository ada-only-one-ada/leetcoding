class Solution {
    public int countHillValley(int[] nums) {
        // Early return if the input array is too small to have any hills or valleys
        if (nums.length < 3) {
            return 0;
        }

        int count = 0; // This will count the number of hills and valleys
        int current = 1; // Start from the second element

        // Loop through the array to find all hills and valleys
        while (current < nums.length - 1) {
            // Find the next index with a different value to determine a potential hill or valley
            int nextDifferent = current;
            while (nextDifferent < nums.length - 1 && nums[current] == nums[nextDifferent]) {
                nextDifferent++;
            }

            // Check if the current index forms a hill
            if (nums[current] > nums[current - 1] && nums[current] > nums[nextDifferent]) {
                count++;
            }
            // Check if the current index forms a valley
            else if (nums[current] < nums[current - 1] && nums[current] < nums[nextDifferent]) {
                count++;
            }

            // Move to the next index where the value changes
            current = nextDifferent;
        }

        return count;
    }
}
