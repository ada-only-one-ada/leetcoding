class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        // diff = nums1[i] − nums2[i]，则问题变成把每个 diff 变成 0 的最小操作次数
        
        // 在 k = 0 的时候，无法操作，可以直接判断是否相等
        if (k == 0) return Arrays.equals(nums1, nums2) ? 0 : -1;

        long increSum = 0;
        long decreSum = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            long diff = nums1[i] - nums2[i];
          
            // 对于 k > 0，由于每个 diff 要变成 0，它必须是 k 的倍数，如果 diff mod k != 0，就无法满足要求
            if (diff % k != 0) return -1; 
            if (diff == 0) continue;

            if (diff < 0) {
                decreSum += diff;
            } else if (diff > 0) {
                increSum += diff;
            }
        }

        // 此外，由于「一个数 +k，另一个数 −k」这个操作不会影响整个 diff 的和，所以如果 增 和 减的 diff 的和不为 0，也无法满足要求
        // 无法通过等量的增加和减少来达到平衡
        if (increSum != -decreSum) return -1; 
        // 统计其中一个转换成k需要多少即可
        return increSum / k;
    }
}

/*
[4,3,1,4] 和 [1,3,7,1] 差距: [3,0,6,3]

[4,3,1,4]
[-,3,+,4] = [1,3,4,4]
[1,3,4,4]
[1,3,+,-] = [1,3,7,1] == [1,3,7,1]
*/