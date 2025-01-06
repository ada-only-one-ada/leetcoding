class Solution {
    public int findMinArrowShots(int[][] points) {
        // 有多少个重叠的
        if (points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int res = 1;
        int prevStart = points[0][0]; // 尽量小
        int prevEnd = points[0][1]; // 尽量大

        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            if (currStart <= prevEnd) {
                prevEnd = Math.min(prevEnd, currEnd);
            } else {
                prevEnd = Math.max(prevEnd, currEnd);
                res++;
            }
        }

        return res;
    }
}

// [1,6], [2,8], [7,12], [10,16]
//    ^            ^11    