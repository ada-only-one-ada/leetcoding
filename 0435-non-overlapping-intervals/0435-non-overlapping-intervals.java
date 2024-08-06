class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int count = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart < prevEnd) {
                // 有重叠，必然得去掉一个，所以count++
                count++;          
                // 如果当前这个更早结束，那就去掉之前那个，因为晚结束的可能会覆盖到后面的
                prevEnd = Math.min(prevEnd, currEnd);
            } else {
                prevEnd = currEnd;
            }
        }

        return count;
    }
}