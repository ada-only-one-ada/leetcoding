class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        
        int start = newInterval[0];
        int end = newInterval[1];

        int i = 0;
        while (i < intervals.length && intervals[i][1] < start) {
            list.add(intervals[i]);
            i++;
        }
        if (i < intervals.length) start = Math.min(intervals[i][0], start);
        
        while (i < intervals.length && intervals[i][0] <= end) {
            end = Math.max(intervals[i][1], end);
            i++;
        }
        
        list.add(new int[]{start, end});

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        
        int[][] res = new int[list.size()][2];
        for (int index = 0; index < list.size(); index++) {
            res[index] = list.get(index);
        }

        return res;
    }
}