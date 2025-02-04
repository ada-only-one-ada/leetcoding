class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;

        Arrays.sort(nums);

        int i1 = 0;
        if (nums[i1]> 0 && nums[i1] > target) return res;
        while (i1 <= nums.length - 4) {
            int i2 = i1 + 1;
            if (nums[i2] > 0 && nums[i1] + nums[i2] > target) return res;

            while (i2 <= nums.length - 3) {
                int i3 = i2 + 1;
                int i4 = nums.length - 1;
                
                while (i3 < i4) {
                    int sum = nums[i1] + nums[i2] + nums[i3] + nums[i4];
                    if (sum == target) {
                        res.add(new ArrayList(Arrays.asList(nums[i1], nums[i2], nums[i3], nums[i4])));
                        i3++;
                        i4--;
                        while (i3 < i4 && nums[i3] == nums[i3-1]) i3++;
                        while (i3 < i4 && nums[i4] == nums[i4+1]) i4--;
                    } else if (sum < target) {
                        i3++;
                    } else if (sum > target) {
                        i4--;
                    }
                }

                i2++;
                while (i2 <= nums.length - 3 && nums[i2] == nums[i2-1]) i2++;
            }

            i1++;
            while (i1 <= nums.length - 4 && nums[i1] == nums[i1-1]) i1++;
        }

        return res;
    }
}