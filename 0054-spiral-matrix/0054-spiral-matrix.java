class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowNum = matrix.length, colNum = matrix[0].length;
        int topRow = 0, bottomRow = rowNum - 1;
        int leftCol = 0, rightCol = colNum - 1;

        while (res.size() < rowNum * colNum) {
            for (int col = leftCol; col <= rightCol && res.size() < rowNum * colNum; col++) {
                res.add(matrix[topRow][col]);
            }
            topRow++;

            for (int row = topRow; row <= bottomRow && res.size() < rowNum * colNum; row++) {
                res.add(matrix[row][rightCol]);
            }
            rightCol--;

            for (int col = rightCol; col >= leftCol && res.size() < rowNum * colNum; col--) {
                res.add(matrix[bottomRow][col]);
            }
            bottomRow--;

            for (int row = bottomRow; row >= topRow && res.size() < rowNum * colNum; row--) {
                res.add(matrix[row][leftCol]);
            }
            leftCol++;
        }

        return res;
    }
}