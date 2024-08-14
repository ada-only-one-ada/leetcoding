class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int num = 1;

        int left = 0;
        int up = 0;
        int right = colNum - 1;
        int down = rowNum - 1;

        while (num <= rowNum * colNum) {
            for (int i = left; i <= right && up <= down; i++) {
                res.add(matrix[up][i]);
                num++;
            }
            up++;

            for (int i = up; i <= down && left <= right; i++) {
                res.add(matrix[i][right]);
                num++;
            }
            right--;

            for (int i = right; i >= left && up <= down; i--) {
                res.add(matrix[down][i]);
                num++;
            }
            down--;

            for (int i = down; i >= up && left <= right; i--) {
                res.add(matrix[i][left]);
                num++;
            }
            left++;
        }

        return res;
    }
}