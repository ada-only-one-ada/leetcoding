class Solution {
    public int removeDuplicates(int[] nums) {
        // 长度小于等于2，一定合法，返回长度即可
        if (nums.length <= 2) return nums.length;

        int replaceIndex = 2;
        // 否则，从第三个数字开始loop
        for (int i = 2; i < nums.length; i++) {
            // 如果当前数字跟即将替代的index的前一个或者前两个不一样，就可以取代
            if (nums[i] != nums[replaceIndex-1] || nums[i] != nums[replaceIndex-2]) {
                nums[replaceIndex++] = nums[i];
            } 
        }
        return replaceIndex;
    }
}