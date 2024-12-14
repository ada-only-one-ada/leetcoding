class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int start = 1;
        int end = x;

        int res = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (mid < x / mid) {
                res = mid;
                start = mid + 1;
            } else if (mid > x / mid) {
                end = mid;
            }
        }

        return res;
    }
}