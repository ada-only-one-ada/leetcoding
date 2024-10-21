class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // i < j，意味着只要不相等即可
        Collections.sort(nums);
        int res = 0;

        int left = 0;
        int right = nums.size() - 1;

        /*
         l         r
        [-1, 1, 1, 2, 3]
        left 和 right 之间的任何一个位置与 left 形成的数对都满足条件:
        (-1, 1), (-1, 1), (-1, 2) : 3 - 0 = 3
        */

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                res += right - left;
                // 寻找下一个可能性
                left++;
            } else {
                // 和太大了，需要减少
                right--;
            }
        }

        return res;
    }
}