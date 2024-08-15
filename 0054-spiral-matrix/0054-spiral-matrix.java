class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int top = 0;
        int down = rowNum - 1;
        int left = 0;
        int right = colNum - 1;

        int added = 0;
        while (added < rowNum * colNum) {
            for (int c = left; c <= right && top <= down; c++) {
                res.add(matrix[top][c]);
                added++;
            }
            top++;

            for (int r = top; r <= down && left <= right; r++) {
                res.add(matrix[r][right]);
                added++;
            }
            right--;

            for (int c = right; c >= left && top <= down; c--) {
                res.add(matrix[down][c]);
                added++;
            }
            down--;

            for (int r = down; r >= top && left <= right; r--) {
                res.add(matrix[r][left]);
                added++;
            }
            left++;
        }

        return res;
    }
}