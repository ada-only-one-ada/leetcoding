class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;

        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                res += right - left;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}