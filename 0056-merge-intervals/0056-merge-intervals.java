class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        if (intervals.length <= 1) return intervals;
        List<int[]> list = new ArrayList<>();

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart > prevEnd) {
                list.add(new int[]{prevStart, prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            } else {
                prevEnd = Math.max(prevEnd, currEnd);
            }
        } 

        list.add(new int[]{prevStart, prevEnd});

        int[][] res = new int[list.size()][2];
        int index = 0;
        for (int[] interval: list) {
            res[index++] = interval;
        }

        return res;
    }
}