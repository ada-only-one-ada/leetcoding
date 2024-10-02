class Solution {
    public int findMinDifference(List<String> timePoints) {
        //根据题意，一共有 24×60=1440 种不同的时间。
        // 由鸽巢原理可知，如果 timePoints 的长度超过 1440，那么必然会有两个相同的时间，此时可以直接返回 0
        if (timePoints.size() > 24 * 60) return 0;
        
        List<Integer> minutes = new ArrayList<>();

        for (String timePoint: timePoints) {
            String[] time = timePoint.split(":");
            int minute = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            minutes.add(minute);
        }

        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            int currMinute = minutes.get(i);
            int lastMinute = minutes.get(i - 1);
            minDiff = Math.min(minDiff, Math.abs(currMinute - lastMinute));

            // 最后一个要跟第 0 个比较，[00: 23, ... , 23:59]
            if (i == minutes.size() - 1) {
                currMinute -= 24 * 60;
                minDiff = Math.min(minDiff, Math.abs(currMinute - minutes.get(0)));
            }
        }
  
        return minDiff;
    }
}