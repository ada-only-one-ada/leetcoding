class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 25 * 60) return 0;

        boolean[] validMinutes = new boolean[24 * 60];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] time = timePoints.get(i).split(":");
            int index = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            
            if (validMinutes[index]) return 0;
            validMinutes[index] = true;
        }

        int res = Integer.MAX_VALUE;

        int firstValid = -1;
        int prevValid = -1;

        for (int i = 0; i < validMinutes.length; i++) {
            if (!validMinutes[i]) continue;

            if (firstValid == -1) firstValid = i;

            if (prevValid != -1) {
                res = Math.min(res, i - prevValid);
            }

            prevValid = i;
        }

        res = Math.min(res, firstValid + 24 * 60 - prevValid);
        return res;
    }
}