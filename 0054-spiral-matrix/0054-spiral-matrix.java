class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int top = 0;
        int bottom = rowNum - 1;
        int left = 0;
        int right = colNum - 1;
        
        while (res.size() < rowNum * colNum) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;

            for (int col = right; col >= left && top <= bottom; col--) {
                res.add(matrix[bottom][col]);
            }
            bottom--;

            for (int row = bottom; row >= top && left <= right; row--) {
                res.add(matrix[row][left]);
            }

            left++;
        }

        return res;
    }
}