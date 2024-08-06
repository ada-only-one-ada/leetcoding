class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        int i1 = 0;
        while (i1 <= nums.length - 3) {
            int i2 = i1 + 1;
            int i3 = nums.length - 1;
            while (i2 <= nums.length - 2 && i2 < i3) {
                int sum = nums[i1] + nums[i2] + nums[i3];
                if (sum == target) {
                    return sum;
                } else {
                    int diff = Math.abs(sum - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        res = sum;
                    }

                    if (sum < target) {
                        i2++;
                        while (i2 < i3 && nums[i2] == nums[i2 - 1]) i2++;   
                    } else {
                        i3--;
                        while (i2 < i3 && nums[i3] == nums[i3 + 1]) i3--;
                    }

                }
            }

            i1++;
            while (i1 <= nums.length - 3 && nums[i1] == nums[i1 - 1]) i1++;
        }

        return res;
    }
}