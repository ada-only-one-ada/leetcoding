class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // 比如[0, 1, 2]和[3, 4]，即[0, 1, 2, 3, 4]，中间的就是5/2 = 2，注意我们要找第3小，因为index从0开始
        // 比如[0, 1]和[2, 3]，即[0, 1, 2, 3]，中间的就是4/2 = 2，我们要找第2小和第1小的，也就是1和2的位置
        // 注意结果要除以2.0因为是double
        int k = (len1 + len2) / 2 + 1;
        if ((len1 + len2) % 2 != 0) { 
            return getKthSmall(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k);
        } else { 
            return (getKthSmall(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k) + 
                    getKthSmall(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k - 1)) / 2.0;
                   
        }
    }

    public int getKthSmall(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1; // 当前数组1 start1 到 end1 有几个数字
        int len2 = e2 - s2 + 1; // 当前数组2 start2 到 end2 有几个数字

        // 让 len1 的长度小于 len 2，这样就能保证如果有数组空了，一定是 len1 
        if (len1 > len2) return getKthSmall(nums2, s2, e2, nums1, s1, e1, k);

        // 出口1: 如果短的数组为空，那么从长的那个数组里面找
        // k 代表个数，那么从 s2 之后找第 k 小的，比如[0,1,2,3,4,5]，找第4小，0+4-1 ，也就是index为3的数字
        if (len1 == 0) return nums2[s2 + k - 1];

        // 出口2: 如果k=1，表明最接近中位数了，即两个数组种start的index，谁的值更小，谁就是第k小的，也就是中位数
        if (k == 1) return Math.min(nums1[s1], nums2[s2]); 

        // 拿到数组1中的第 k/2 小，和数组2中的第 k/2 小
        // 数组1: 【前k1, 后k1】
        // 数组2: 【前k2，后k2】
        int k1 = Math.min(s1 + k/2 - 1, e1);
        int k2 = Math.min(s2 + k/2 - 1, e2);
 
        if (nums1[k1] > nums2[k2]) {
            return getKthSmall(nums1, s1, e1, nums2, k2 + 1, e2, k - (k2 - s2 + 1));
        } else {
            return getKthSmall(nums1, k1 + 1, e1, nums2, s2, e2, k - (k1 - s1 + 1));
        }
    }
}