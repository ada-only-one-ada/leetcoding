class Solution {
    public int maxValue(int n, int index, int maxSum) {
        // 不超过 maxSum，数字越小越好
        // 每个数字都要大于等于1，所以左边最小的数字不能减到0，如果到了1还有元素，那么剩下的都是1；右边同样

        long leftNum = index; // 左边的数字个数
        long rightNum = n - leftNum - 1; // 右边的数字个数

        // 二分法
        int start = 1;
        int end = maxSum + 1;
        while (start < end) {
            int candidate = start + (end - start) / 2;

            // 比如当前candidate = 4，那么左边 >= 1的数字个数有3（3，2，1)
            // 但这个positive的个数不能大于总数
            long leftPositiveNum = Math.min(leftNum, candidate - 1); 
            long leftSum = leftPositiveNum * candidate - (((leftPositiveNum * (leftPositiveNum + 1))) / 2);
            // 还有剩下的全部值为1
            leftSum += leftNum - leftPositiveNum;
            
            long rightPositiveNum = Math.min(rightNum, candidate - 1);
            long rightSum =  rightPositiveNum * candidate - (((rightPositiveNum * (rightPositiveNum + 1))) / 2);
            rightSum += rightNum - rightPositiveNum;

            long total = leftSum + rightSum + candidate;
            if (total <= maxSum) {
                start = candidate + 1;
            } else {
                end = candidate;
            }
        }
      
        return start - 1;
    }
}