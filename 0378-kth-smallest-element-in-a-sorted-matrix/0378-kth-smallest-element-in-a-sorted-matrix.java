class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int startValue = matrix[0][0];
        int endValue = matrix[n-1][n-1] + 1;
        while (startValue < endValue) {
            int midValue = startValue + (endValue - startValue) / 2;

            int lessOrEqual = countLessOrEqual(matrix, midValue);
            if (lessOrEqual >= k) {
                endValue = midValue;
            } else {
                startValue = midValue + 1;
            }
        }

        return startValue;
    }

    public int countLessOrEqual(int[][] matrix, int value) {
        int row = 0;
        int col = matrix[0].length - 1;

        int res = 0;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] <= value) {
                res += col + 1;
                row++;
            } else {
                col--;
            }
        }

        return res;
    }
}