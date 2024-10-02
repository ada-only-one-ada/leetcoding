class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        for (String timePoint: timePoints) {
            String[] time = timePoint.split(":");
            int minute = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            minutes.add(minute);
        }

        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            int currMinute = minutes.get(i);
            int lastMinute = minutes.get(i - 1);
            minDiff = Math.min(minDiff, Math.abs(currMinute - lastMinute));

            if (i == minutes.size() - 1) {
                currMinute -= 24 * 60;
                minDiff = Math.min(minDiff, Math.abs(currMinute - minutes.get(0)));
            }
        }

        
        return minDiff;
    }
}