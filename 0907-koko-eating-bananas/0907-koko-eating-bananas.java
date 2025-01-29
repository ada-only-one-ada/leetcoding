class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Integer.MAX_VALUE;

        while (minSpeed < maxSpeed) {
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canFinish(piles, h, midSpeed)) {
                maxSpeed = midSpeed;
            } else {
                minSpeed = midSpeed + 1;
            }
        }

        return minSpeed;
    }

    public boolean canFinish(int[] piles, int h, int speed) {
        int totalHours = 0;

        for (int pile: piles) {
            if (pile <= speed) {
                totalHours++;
            } else if (pile % speed == 0) {
                totalHours += pile / speed;
            } else if (pile % speed != 0) {
                totalHours += pile / speed + 1;
            }
        }

        return totalHours <= h;
    }
}