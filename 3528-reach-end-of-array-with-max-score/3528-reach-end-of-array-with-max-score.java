class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long res = 0;

        long currNum = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > currNum || i == nums.size() - 1) {
                res += currNum * (i - j);
                currNum = nums.get(i);
                j = i;
            }
        }

        return res;
    }
}