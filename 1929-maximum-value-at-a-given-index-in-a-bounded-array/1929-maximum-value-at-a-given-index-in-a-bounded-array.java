class Solution {
    public int maxValue(int n, int index, int maxSum) {
        // 不超过 maxSum，数字越小越好

        long leftNum = index;
        long rightNum = n - leftNum - 1;

        long start = 1;
        long end = maxSum + 1;
        long res = -1;
        while (start < end) {
            long candidate = start + (end - start) / 2;

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
      
        return (int)res;
    }
}