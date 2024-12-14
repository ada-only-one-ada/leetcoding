class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1;
        int end  = x;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid == x / mid) {       // mid * mid = x
                return mid;
            } else if (mid < x / mid) { // mid * mid < x，有可能是这个mid 或者之后的mid
               start = mid + 1;
            } else if (mid > x / mid) { // mid * mid > x， 肯定不是这个mid
               end = mid;
            }
        }

        if (start > x / start) return start- 1; // start * start > x
        return start;
    }
}