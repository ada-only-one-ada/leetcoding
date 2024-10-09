public class Solution {
    // 方法用于找出矩阵中第k小的元素
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;                 // 方阵的维度
        int low = matrix[0][0];                // 最小元素
        int high = matrix[n - 1][n - 1];       // 最大元素

        while (low <= high) {
            int midVal = low + (high - low) / 2; // 计算中间值
            int count = countInMatrix(matrix, midVal); // 计算矩阵中小于等于中间值的元素数量

            if (count < k) {  // 如果计数小于k，说明第k小的元素在右侧
                low = midVal + 1; // 将下界调整为中间值加一
            } else {             // 否则，在左侧
                high = midVal - 1; // 将上界调整为中间值减一
            }
        }
        return low; // low将是第k小的元素
    }

    // 方法用于计算矩阵中小于等于midVal的元素数量
    private int countInMatrix(int[][] matrix, int midVal) {
        int n = matrix.length;          // 方阵的维度，n行n列
        int count = 0;                  // 计数小于等于midVal的元素数量
        int row = 0;                    // 从第一行开始
        int col = n - 1;                // 从最后一列开始

        while (row < n && col >= 0) {
            if (midVal >= matrix[row][col]) { // 如果中间值大于等于当前元素
                count += col + 1;             // 累加当前列之前的所有元素（包括当前列）
                row++;                        // 移动到下一行
            } else {                          // 如果中间值小于当前元素
                col--;                        // 列指针左移，检查前一列
            }
        }
        return count;
    }
}
