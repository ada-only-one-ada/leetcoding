class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;    // 第0本书前没有书，最小高度为0

        // 前 i 本书 所需要的最小高度
        for (int i = 1; i < dp.length; i++) {
            int[] book = books[i - 1];
            int currWidth = book[0];
            int currHeight = book[1];
            
            // 无脑新建一个书架 
            dp[i] = dp[i - 1] + currHeight;

            // 尝试放到之前 可行的 前 j 本书所需要的最小高度
            // 从第 j 本书开始向前尝试将书放在当前层
            for (int j = i - 1; j >= 1; j--) {
                currWidth += books[j - 1][0];
                if (currWidth > shelfWidth) break; // 第 j 本放不下，停止向前拿书
                
                currHeight = Math.max(currHeight, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + currHeight);  // j 本书以后新建书架
            }
        }

        return dp[books.length];

    }
}