class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int max = 0;

        for (int d: damage) {
            sum += d;
            max = Math.max(max, d);
        }

        return sum - Math.min(armor, max) + 1;
    }
}