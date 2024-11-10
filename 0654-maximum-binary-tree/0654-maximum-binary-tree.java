class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int maxIndex = getMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, end);

        return root;
    }

    public int getMaxIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = start; i <= end; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}