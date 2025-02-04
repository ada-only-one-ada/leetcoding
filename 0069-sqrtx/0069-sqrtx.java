class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int left = 1;
        int right = x;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else if (mid > x / mid) {
                right = mid;
            }
        }

        if (left < x / left) {
            return left;
        }

        return left - 1;
    }
}