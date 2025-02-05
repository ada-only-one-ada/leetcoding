class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int i = 0;
        while (i < intervals.length && newStart > intervals[i][1]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }

        list.add(new int[]{newStart, newEnd});

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        int[][] res = new int[list.size()][2];
        for (int index = 0; index < res.length; index++) {
            res[index] = list.get(index);
        }

        return res;
    }
}