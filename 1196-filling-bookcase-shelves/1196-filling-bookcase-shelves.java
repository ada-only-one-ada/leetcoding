class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int currWidth = 0;
            int currMaxHeight = 0;
            int j = i;

            while (j >= 1) {
                currWidth += books[j - 1][0];  // 累加当前书的宽度
                if (currWidth > shelfWidth) {  // 如果当前宽度超出书架宽度
                    break;  // 跳出循环，不能继续在这一层上放置书籍
                }
                // 更新当前层的最大高度
                currMaxHeight = Math.max(currMaxHeight, books[j - 1][1]);
                // 更新dp数组，考虑在j-1处结束前一层书架，开始新的一层
                dp[i] = Math.min(dp[i], dp[j - 1] + currMaxHeight);

                j--;  // 继续考虑前一本书是否加入当前层
            }
        }

        return dp[n];  // 返回全部书籍放置完成后的最小总高度。
    }
}
