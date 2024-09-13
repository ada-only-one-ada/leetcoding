class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) return Arrays.equals(nums1, nums2) ? 0 : -1;
        long increSum = 0;
        long decreSum = 0;

        for (int i = 0; i < nums1.length; i++) {
            long diff = nums1[i] - nums2[i];
            if (diff % k != 0) return -1;
            if (diff == 0) continue;

            if (diff < 0) {
                decreSum += diff;
            } else if (diff > 0) {
                increSum += diff;
            }
        }

        if (increSum + decreSum != 0) return -1;
        return increSum / k;
    }
}


// [4,3,1,4] 和 [1,3,7,1] 差距: [3,0,6,3]

        // [4,3,1,4]
        // [-,3,+,4] = [1,3,4,4]
        
        // [1,3,4,4]
        // [1,3,+,-] = [1,3,7,1] == [1,3,7,1]