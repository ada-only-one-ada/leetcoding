class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> list = new ArrayList<>();
        
        int start = newInterval[0];
        int end = newInterval[1];

        int i = 0;
        // 正确加入:
        //【start，end】->【newStart，newEnd】，end是小于新的start
        // 如果当前end是小于新start的，可以把当前interval加入res
        while (i < intervals.length && intervals[i][1] < start) {
            list.add(intervals[i]);
            i++;
        }

        // 更新重叠中的起始点
        if (i < intervals.length) {
            start = Math.min(intervals[i][0], start);
        }
        
        // 错误更新:
        //【newStart，newEnd】->【start，end】，新end要小于当前start
        // 如果新end大于等于当前start的话，意味着有重叠，要更新
        while (i < intervals.length && intervals[i][0] <= end) {
            end = Math.max(intervals[i][1], end);
            i++;
        }
        
        list.add(new int[]{start, end});

        // 后面还剩下一些不重叠的要记得加入
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        
        return list.toArray(new int[list.size()][2]);
        /*
        int[][] res = new int[list.size()][2];
        for (int index = 0; index < list.size(); index++) {
            res[index] = list.get(index);
        }
        return res;
        */
    }
}