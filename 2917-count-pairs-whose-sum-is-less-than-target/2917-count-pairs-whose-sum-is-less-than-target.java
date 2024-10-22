class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;

        int left = 0;
        int right = nums.size() - 1;

        while (left < right) { // 找最后一个和nums[left] 相加，小于target的数字
            int start = left + 1; // 找右边界：右边界的最小
            int end = right + 1;  // 找右边界： 右边界的最大
            int candidate = -1; // 右边界的最小候选者

            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums.get(left) + nums.get(mid) < target) {
                    candidate = mid;
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if (candidate > left) res += candidate - left;
            left++;
            right = candidate;
        }

        return res;
    }
}