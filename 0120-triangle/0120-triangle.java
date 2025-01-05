class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        int sum = 0;
        
        for (int row = triangle.size() - 1; row >= 0; row--){
            for (int col = 0; col <= row; col++){
                int number = triangle.get(row).get(col);
                dp[col] = number + Math.min(dp[col], dp[col + 1]);
            }
        }
         
        return dp[0];
    }
}

/*
    2
   3 4
  6 5 7
 4 1 8 3
0 0 0 0 0  

initial dp array set to 0: dp[0, 0, 0, 0, 0] 
row 4 1 8 3: dp[4, 1, 8,  3, -]
row 6 5 7:   dp[7, 6, 10, -, -]
row 3 4:     dp[9, 10, -, -, -]
row 2:       dp[11, -, -, -, -]
*/



