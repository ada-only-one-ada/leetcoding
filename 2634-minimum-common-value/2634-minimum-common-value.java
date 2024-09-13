class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = nums1.length - 1;
        int j = nums2.length - 1;

        int res = -1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] == nums2[j]) {
                res = nums1[i];
                i--;
                j--;
            } else if (nums1[i] < nums2[j]) {
                j--;
            } else if (nums1[i] > nums2[j]) {
                i--;
            }
        }

        return res;
    }
}