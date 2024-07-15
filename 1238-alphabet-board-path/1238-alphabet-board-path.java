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