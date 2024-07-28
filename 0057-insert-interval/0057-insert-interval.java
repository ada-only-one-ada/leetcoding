class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
       
        //无脑把绝对不可能重叠的加入res   
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newStart) {
            res.add(intervals[i]);
            i++;
        }

       // pre，【a，b，c，d....】
       // 有可能newIntervals的起点先，或者a的起点先，把先的那个设置成prev
        int[] prev = newInterval;
        if (i < intervals.length && prev[0] < newStart){
            int[] temp = prev;
            intervals[i] = prev;
            prev = temp;
        }
        if (i < intervals.length) {
            prev[0] = Math.min(prev[0], intervals[i][0]);
        }
        
        for (int j = i; j < intervals.length; j++) {
            int[] curr = intervals[j]; 
            if (curr[0] > prev[1]) {
                res.add(prev);
                prev = curr;
            } else {
                //prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }

        res.add(prev);
        return res.toArray(new int[res.size()][2]);
    }
}