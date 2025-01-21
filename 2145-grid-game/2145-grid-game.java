class Solution {
    public long gridGame(int[][] grid) {
        int colNum = grid[0].length;  // 网格的列数
        // 使用前缀和数组来存储两行的累加和，直接使用长度为 colNum 的数组
        long[][] prefixSum = new long[2][colNum];

        // 初始化第一列前缀和为第一个元素
        prefixSum[0][0] = grid[0][0];
        prefixSum[1][0] = grid[1][0];

        // 从第二个元素开始计算前缀和
        for (int col = 1; col < colNum; col++) {
            prefixSum[0][col] = prefixSum[0][col - 1] + grid[0][col];
            prefixSum[1][col] = prefixSum[1][col - 1] + grid[1][col];
        }

        long res = Long.MAX_VALUE; 

        for (int col = 0; col < colNum; col++) {
            // 计算两个关键点：第一行行剩余的总和，与第二行前缀的总和
            
            // 第一行，如果是最后一列，说明左边的都被吃掉了，剩下 0
            // 否则计算右边剩下的总和
            long firstRow = (col == colNum - 1) ? 0 : prefixSum[0][colNum - 1] - prefixSum[0][col];

            // 第一行，如果是第一列，说明左边没有东西可吃
            // 否则计算左边剩下的总和
            long secondRow = (col == 0) ? 0 : prefixSum[1][col - 1];
       
            // 保留更小的那个
            res = Math.min(res, Math.max(firstRow, secondRow));
        }
        
        return res;  
    }
}
