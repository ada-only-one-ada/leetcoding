class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;

        Collections.sort(timePoints, (a, b) -> {
            String[] timeA = a.split(":");
            String[] timeB = b.split(":");

            int hourA = Integer.valueOf(timeA[0]);
            int hourB = Integer.valueOf(timeB[0]);
            int minA = Integer.valueOf(timeA[1]);
            int minB = Integer.valueOf(timeB[1]);

            if (hourA == hourB) {
                return minA - minB;
            }

            return hourA - hourB;
        });
        

        for (int i = 0; i < timePoints.size(); i++) {
            int left = i - 1;
            boolean isFirst = false;
            if (i == 0) {
                isFirst = true;
                left = timePoints.size() - 1;
            }

            minDiff = Math.min(minDiff, compare(timePoints.get(left), timePoints.get(i), isFirst));
            if (minDiff == 0) return minDiff;
        }

        return minDiff;
    }

    public int compare(String s1, String s2, boolean isFirst) {
        if (s1.equals(s2)) return 0;

        String[] timeA = s1.split(":");
        String[] timeB = s2.split(":");

        int hourA = Integer.valueOf(timeA[0]);
        int hourB = Integer.valueOf(timeB[0]);
        int minA = Integer.valueOf(timeA[1]);
        int minB = Integer.valueOf(timeB[1]);

        if (isFirst) hourB += 24;

        return Math.abs(hourA - hourB) * 60 + (minB - minA);
    }
}