class Solution {
    public int maxValue(int n, int index, int maxSum) {
        // 不超过 maxSum，数字越小越好
        // 每个数字都要大于等于1，所以左边最小的数字不能减到0，如果到了1还有元素，那么剩下的都是1；右边同样

        long leftNum = index;
        long rightNum = n - leftNum - 1;

        int start = 1;
        int end = maxSum + 1;
        int res = -1;
        while (start < end) {
            int candidate = start + (end - start) / 2;

            long leftPositiveNum = Math.min(leftNum, candidate - 1);
            long leftSum = leftPositiveNum * candidate - (((leftPositiveNum * (leftPositiveNum + 1))) / 2);
            leftSum += leftNum - leftPositiveNum;
            
            long rightPositiveNum = Math.min(rightNum, candidate - 1);
            long rightSum =  rightPositiveNum * candidate - (((rightPositiveNum * (rightPositiveNum + 1))) / 2);
            rightSum += rightNum - rightPositiveNum;

            long total = leftSum + rightSum + candidate;
           
            if (total <= maxSum) {
                res = candidate;
                start = candidate + 1;
            } else {
                end = candidate;
            }
        }
      
        return res;
    }
}