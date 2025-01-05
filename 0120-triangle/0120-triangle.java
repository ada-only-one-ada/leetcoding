class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
        0 1 2 3
        ------------
        2
        3 4
        6 5 7 （5可以由3过来，也可以由4过来）
        4 1 8 3 （1可以由6过来，也可以由5过来；8可以由5过来，也可以由7过来）

        过程：
         0  1  2  3 
        [2]
        [5,6]
        [11,10,13]   
        */

        List<Integer> dp = new ArrayList<>();
        dp.add(triangle.get(0).get(0));

        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> temp = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                int number = triangle.get(row).get(col);
                int minPathSum = Integer.MAX_VALUE;

                if (col - 1 >= 0) {
                    minPathSum = Math.min(minPathSum, number + dp.get(col - 1));
                }

                if (col < dp.size()) {
                    minPathSum = Math.min(minPathSum, number + dp.get(col));
                }

                temp.add(minPathSum);
            }

            dp = temp;
        }

        int res = Integer.MAX_VALUE;
        for (int sum: dp) {
            res = Math.min(res, sum);
        }

        return res;
    }
}