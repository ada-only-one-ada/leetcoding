class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;

        while (m - 1 >= 0 && n - 1 >= 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[index--] = nums1[m - 1];
                m--;
            } else {
                nums1[index--] = nums2[n - 1];
                n--;
            }
        }

        while (m - 1 >= 0) {
            nums1[index--] = nums1[m - 1];
            m--;
        }

        while (n - 1 >= 0) {
            nums1[index--] = nums2[n - 1];
            n--;
        }
    }
}