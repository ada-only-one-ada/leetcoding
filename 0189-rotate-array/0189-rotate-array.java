class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        int start = 0;

        while (count < nums.length) {
            int prevIndex = start;
            int prevNum = nums[start];

            while (true) {
                int newIndex = (prevIndex + k) % nums.length;
                int newNum = nums[newIndex];
                nums[newIndex] = prevNum;
                count++;

                prevIndex = newIndex;
                prevNum = newNum;

                if (newIndex == start) break;
            }

            start++;
        }
    }
}