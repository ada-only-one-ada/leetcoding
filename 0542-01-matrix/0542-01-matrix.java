class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                // 如果等於1，说明我们要去求这个cell到最近的一个0的cell的距离，先把距离设置成一个无限大的值
                if (mat[row][col] == 1) {
                    // use Integer.MAX_VALUE then add one will cause overflow, we can use Integer.MAX_VALUE - 1
                    res[row][col] = mat.length * mat[0].length + 1;
                }
            }
        }

        // 起点在left - top
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                // 是0的话表示这个位置本身是0，不用求
                if (res[row][col] == 0) continue;
                
                // 否则求距离，初始距离是剛才設置的无限大的一个值
                int distance = res[row][col];
                if (row > 0) distance = Math.min(distance, res[row - 1][col]); // upper
                if (col > 0) distance = Math.min(distance, res[row][col - 1]); // left
                // 从无限大 -> update到另一个更小的距离 （到达上一个点所需要的距离，再加1个）
                res[row][col] = 1 + distance;
            }
        }

        // 起点在bottom - right
        for (int row = res.length - 1; row >= 0; row--) {
            for (int col = res[0].length - 1; col >= 0; col--) {
                if (res[row][col] == 0) continue;

                // 这个距离不是无限大的那个，是上一次loop中更新的距离
                int distance = res[row][col];
                if (row < res.length - 1) distance = Math.min(distance, res[row + 1][col]);
                if (col < res[0].length - 1) distance = Math.min(distance, res[row][col + 1]);

                // 比较左上出发快还是右下出发快
                res[row][col] = Math.min(res[row][col] , 1 + distance);
            }
        }
        
        return res;
    }
}