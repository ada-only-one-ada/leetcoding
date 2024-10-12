class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0;
        for (int pile: piles) {
            sum += pile;
        }

        int start = 1;
        int end = Integer.MAX_VALUE;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (canFinish(piles, h, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        int i = 0;
        while (i < piles.length) {
            if (piles[i] <= k) {
                hours++;
                i++;
            } else {
                hours += piles[i] / k;
                if (piles[i] % k != 0) {
                    hours++;
                }
                i++;
            }
        }

        return hours <= h;
    }
}