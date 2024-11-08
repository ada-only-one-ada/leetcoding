class Solution {
    public int sumOfUnique(int[] nums) {
        int[] state = new int[101];
        // 0 代表 刚遇见
        // 1 代表 遇见过，现在要减去
        // 2 代表 这个数字出现了两次以上，不用加也不用减

        int sum = 0;
        for (int num: nums) {
            if (state[num] == 0) {
                sum += num;
                state[num] = 1;
            } else if (state[num] == 1) {
                sum -= num;
                state[num] = 2;
            }
        }

        return sum;
    }
}