class Solution {
    public int findMinArrowShots(int[][] points) {
        // 有多少个重叠的
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> {
           // if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int res = 1;
        int prevStart = points[0][0]; 
        int prevEnd = points[0][1]; 

        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            if (currStart <= prevEnd) {
                prevEnd = Math.min(prevEnd, currEnd);
            } else {
                // 没有重叠，需要额外的一支箭
                // 射在重叠的较大点，因为越往后范围越大，射在较大点可以包括的范围更广
                prevEnd = currEnd;
                res++;
            }
        }

        return res;
    }
}

// [1,6], [2,8], [7,12], [10,16]
//    ^            ^11    