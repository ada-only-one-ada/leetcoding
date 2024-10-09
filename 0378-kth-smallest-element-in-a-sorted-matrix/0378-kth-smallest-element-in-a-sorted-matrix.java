class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int candidate = -1;
        int startValue = matrix[0][0];
        int endValue = matrix[rowNum - 1][colNum - 1] + 1;

        while (startValue < endValue) {
            int midValue = startValue + (endValue - startValue) / 2;
            int lessOrEqual = count(matrix, midValue);

            if (lessOrEqual >= k) {
                candidate = midValue;
                endValue = midValue;
            } else {
                startValue = midValue + 1;
            }
        }

        return candidate;
    }

    public int count(int[][] matrix, int value) {
        int count = 0;

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > value) {
                // 注意：matrix每一行从左到右递增，每一列从上到下递增
                col--;
                // 小于或等于，因为一样的也在算k里面
            } else {
                count += col + 1;
                row++;
            }
        }

        return count;
    }
}