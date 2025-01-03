class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length;
        
        while (startCol < endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            // 确保上下是最大的
            // 找到 midCol 中的最大值在哪一行
            int maxRow = findMaxRow(mat, midCol);
            // 拿到 midCol 中的最大值
            int midColMax = mat[maxRow][midCol];

            // 确保左右是最大的
            int leftCol = midCol - 1;
            // 拿到左边那一列的最大值
            int leftColMax = leftCol >= 0? mat[findMaxRow(mat, leftCol)][leftCol] : Integer.MIN_VALUE;

            int rightCol = midCol + 1;
            // 拿到右边那一列的最大值
            int rightColMax = rightCol < mat[0].length? mat[findMaxRow(mat, rightCol)][rightCol] : Integer.MIN_VALUE;

            // 当前 midCol 这一列比左右两边的都大了，直接返回
            /*
              55   77    9
              56   21    59
              68   1     77
            */
            // 这里先找到77，左边最大是68，右边最大是77，这种情况下第一个 if 不会返回
            // if (midColMax > leftColMax && midColMax > rightColMax) 是错的
            // 加一个等号可以通过
            // 注意读题 where no two adjacent cells are equal
            if (midColMax >= leftColMax && midColMax >= rightColMax) {
                return new int[]{maxRow, midCol};
            // 如果左边那一列的最大值更大，大值在左边，往左边找
            } else if (leftColMax > midColMax) {
                endCol = midCol;
            // 如果右边那一列的最大值更大，大值在右边，往右边找
            } else {
                startCol = midCol + 1;
            }
        }

        return new int[]{-1, -1};
    }


    // 确保上下是最大的
    public int findMaxRow(int[][] mat, int col) {
        int maxRow = 0;

        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] >= mat[maxRow][col]) {
                maxRow = row;
            }
        }

        return maxRow;
    }
}
