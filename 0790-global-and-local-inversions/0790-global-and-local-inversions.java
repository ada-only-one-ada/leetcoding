class Solution {
    public boolean isIdealPermutation(int[] nums) {
        /* 不要纠结找到 local 和 global 的具体数量
           我们只要证明它们不等即可
           根据题意，只要是 local 就是 global，也就是说 global 包括了 local
           所以 global 的数量一定是大于等于 local 的
           只要我们证明了 global 大于 local，就返回false
           如果证明 global 大于 local？只要找到一个 global(不相邻)就可以了
        */

        int globalMax = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            // Note: update 的是不相邻的 
            globalMax = Math.max(globalMax, nums[i - 2]);

            if (globalMax > nums[i]) {
                return false;
            }
        }

        return true;
    }
}