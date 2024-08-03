class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int prevStart = intervals[i - 1][0];
            int prevEnd = intervals[i - 1][1];

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart > prevEnd) {
                list.add(intervals[i - 1]);
            } else {
                intervals[i][0] = prevStart;
                intervals[i][1] = Math.max(prevEnd, currEnd);
            }
        }

        list.add(new int[]{intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]});
        return list.toArray(new int[list.size()][]);
    }
}