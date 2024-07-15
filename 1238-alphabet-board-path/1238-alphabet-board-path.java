class Solution {
    public String alphabetBoardPath(String target) {
        /*
        97,  98,  99,  100, 101
        102, 103, 104, 105, 106
        107, 108, 109, 110, 111
        112, 113, 114, 115, 116
        117, 118, 119, 120, 121
        122
        */

        int currRow = 0;
        int currCol = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            int value = target.charAt(i) - 'a';
            int targetRow = value / 5;
            int targetCol = value % 5;

            // 注意4个while loop的顺序matters：左、上、右、下
            // 左上放在前面，这样就可以保证别的点去z点不会越界（往左再下），z点去别的点（往上再右）也不会越界

            while (currCol > targetCol) {
                currCol--;
                res.append('L');
            }
            
            while (currRow > targetRow) {
                currRow--;
                res.append('U');
            }

            while (currCol < targetCol) {
                currCol++;
                res.append('R');
            }

            while (currRow < targetRow) {
                currRow++;
                res.append('D');
            }

            res.append('!');
        }

        return res.toString();
    }
}