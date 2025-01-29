class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int iMax = 0;
        int jMax = 0;
        int res = 0;

        while (i < j) {
            int ih = height[i];
            int jh = height[j];

            iMax = Math.max(iMax, ih);
            jMax = Math.max(jMax, jh);

            if (ih < jh) {
                res += iMax - ih;
                i++;
            } else {
                res += jMax - jh;
                j--;
            }
        }

        return res;
    }
}