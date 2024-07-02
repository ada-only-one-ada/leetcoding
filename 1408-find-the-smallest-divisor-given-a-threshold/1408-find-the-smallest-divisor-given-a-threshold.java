class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1; 
        int end = Integer.MAX_VALUE;

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            for (int num: nums) {
                if (num % mid != 0) {
                    sum++;
                }
                sum += num / mid;
            }
            
            // 太大了超过了，我们要找一个更大的divisor，来缩小sum
            if (sum > threshold) {
                start = mid + 1;
            // 因为roundup，比如 1/5 跟 1/20 是一样的所以不能直接返回 mid
            // 刚好或者更小，说明我们可以找一个更小的divisior
            } else {
                end = mid;
            }
        }

        return start;
    }
}