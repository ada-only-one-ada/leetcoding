class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) return 0;

        int min = Integer.MAX_VALUE;
        boolean[] minute = new boolean[24 * 60];

        for (int i = 0; i < timePoints.size(); i++) {
            String[] time = timePoints.get(i).split(":");
            int total = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            if (minute[total]) return 0; // two same time
            minute[total] = true;
        }

        int prev = -1;
        int first = -1;

        for (int i = 0; i < minute.length; i++) {
            if (!minute[i]) continue;
            if (first == -1) first = i;

            if (prev != -1) {
                min = Math.min(min, i - prev);
            }
            prev = i;
        }

        min = Math.min(min, first + 24 * 60 - prev);

        return min;
    }
}