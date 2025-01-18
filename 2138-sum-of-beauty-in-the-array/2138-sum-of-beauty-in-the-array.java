class Solution {
    public int sumOfBeauties(int[] nums) {
        int sum = 0;

        // 在 i 左边的都比 nums[i] 小， 在 i 右边的都比 nums[i] 大: 2
        // nums[i-1] < nums[i] < nums[i+1]

        int[] min = new int[nums.length];
        int[] max = new int[nums.length];

        min[0] = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.max(min[i - 1], nums[i - 1]);
        }

        max[max.length - 1] = Integer.MAX_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            max[i] = Math.min(max[i + 1], nums[i + 1]);
        }

        for (int i = 1; i <= nums.length - 2; i++) {
            if (nums[i] > min[i] && nums[i] < max[i]) {
                sum += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }

        return sum;
    }
}