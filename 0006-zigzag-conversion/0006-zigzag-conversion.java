class Solution {
    int ROW_UP = -1;
    int ROW_DOWN = 1;
    int COL_RIGHT = 1;
    int COL_STAY = 0;
    
    public String convert(String s, int numRows) {
        // "AB"，1，如果只能有一行，直接返回
        if (numRows == 1) return s;

        Map<Integer, StringBuilder> map = new HashMap<>();
        helper(s, numRows, 0, ROW_DOWN, 0, COL_STAY, 0, map);

        StringBuilder res = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            if (map.get(row) == null) continue; // A，2，不足两行

            res.append(map.get(row));
        }
        return res.toString();
    }

    public void helper(String s, int numRows, int currRow, int rowDir, int currCol, int colDir, int index, Map<Integer, StringBuilder> map) {
        if (index == s.length()) return;

        map.putIfAbsent(currRow, new StringBuilder());
        map.get(currRow).append(s.charAt(index));

        // 当前行是最后一行，行无法向下了，这时候改变：行数方向向上，列数方向向右
        if (currRow == numRows - 1) {
            helper(s, numRows, currRow - 1, ROW_UP, currCol + 1, COL_RIGHT, index + 1, map);
        // 当前行是第一行，行无法向上了，这时候改变：行数方向向下，列数方向stay
        } else if (currRow == 0) {
            helper(s, numRows, currRow + 1, ROW_DOWN, currCol, COL_STAY, index + 1, map);
        // 否则朝当前方向走
        } else {
            helper(s, numRows, currRow + rowDir, rowDir, currCol + colDir, colDir, index + 1, map);
        }
    }
}