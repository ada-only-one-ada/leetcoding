class Solution {
    public int findMinArrowShots(int[][] points) {
        // 有多少个重叠的
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int res = 1;
        int prevEnd = points[0][1]; 

        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            // 没有重叠，需要额外的一支箭
            if (currStart > prevEnd) {
                res++;
                // 新开的尽量远
                // 这里的 currEnd 一定是比 prevEnd 大的，因为 currStart 就已经比 prevEnd 大了
                prevEnd = currEnd;
            // 有重叠
            } else {
                // 只能在重叠的最大点，即较小的那个
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }

        return res;
    }
}

// [1,6], [2,8], [7,12], [10,16]
//    ^            ^11    