class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > prevEnd) {
                list.add(new int[]{prevStart, prevEnd});
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            } else if (intervals[i][0] <= prevEnd){
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            }
        }

        list.add(new int[]{prevStart, prevEnd});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}