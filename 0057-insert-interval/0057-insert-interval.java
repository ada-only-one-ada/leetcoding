class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 读题目：You are given an array of non-overlapping intervals
        
        if (intervals.length == 0) return new int[][]{newInterval};
       

        List<int[]> list = new ArrayList<>();
        int insertStart = newInterval[0];
        int insertEnd = newInterval[1];

        int index = 0;
        while (index < intervals.length && intervals[index][1] < insertStart) {
            list.add(intervals[index]);
            index++;
        }
      
        while (index < intervals.length && intervals[index][0] <= insertEnd) {
            insertStart = Math.min(insertStart, intervals[index][0]);
            insertEnd = Math.max(insertEnd, intervals[index][1]);
            index++;
        }

        list.add(new int[]{insertStart, insertEnd});
        while (index < intervals.length) {
            list.add(intervals[index]);
            index++;
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}