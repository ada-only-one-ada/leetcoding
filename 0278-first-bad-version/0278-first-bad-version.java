public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        // n could be 2147483647, if (n+1) error
        int right = Integer.MAX_VALUE; 

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}