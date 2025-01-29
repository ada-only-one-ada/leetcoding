class Solution {
    public int minimumOperations(int[] nums) {
        // 从后往前找，一旦我们找到重复的，意味着前面的全部都要删掉

        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                int numToDelete = i + 1;

                return numToDelete / 3 + (numToDelete % 3 == 0? 0:1);
            }

            set.add(nums[i]);
        }

        return 0;
    }
}