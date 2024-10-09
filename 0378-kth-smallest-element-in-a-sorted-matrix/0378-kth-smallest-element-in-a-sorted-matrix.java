class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int startValue = matrix[0][0];
        int endValue = matrix[n - 1][n - 1] + 1;

        while (startValue < endValue) {
            int midValue = startValue + (endValue - startValue) / 2;
            // 在这个matrix中，有count个数字比midValue小
            int count = countLessOrEqual(matrix, midValue);
            // 在这个matrix中，有至少k个的数字比midValue小
            // 说明第k小的数字肯定在前面
            // 也就是说，第k小的数字肯定在 [startValue, midValue] 之间
            if (count >= k) {
                endValue = midValue;
            // 第k小的数字肯定在后面
            // 也就是说，第k小的数字肯定在 (midValue, endValue) 之间
            } else {
                startValue = midValue + 1;
            }
        }

        return startValue;
    }

    // 数小于或等于 midValue 的数有几个
    public int countLessOrEqual(int[][] matrix, int midValue) {
        int count = 0;        

        int n = matrix.length;
        int row = 0;
        int col = n - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] <= midValue) {
                // 因为当前行是递增的，所以当前行有col个数都小于等于midValue
                count += col + 1; 
                row++;
            } else {
                // 否则，往左移直到找到小于等于midValue的
                // 如果到0了都没找到小于等于midValue的，说明也没有必要往下找了，因为下一行肯定比当前的数字大
                col--; 
            }
        }

        return count;
    }
}