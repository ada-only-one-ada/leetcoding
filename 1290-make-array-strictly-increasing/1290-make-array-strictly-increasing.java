class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // 最坏的情况下，arr1中的每个数字都被替换
        int maxOps = arr1.length;

        // arr2排序，便于取最小的值（进一步优化: 去重）
        Arrays.sort(arr2);

        // dp[i][ops] = min: 替换ops次，使得前i个元素递增的最小结尾值
        int[][] dp = new int[arr1.length][maxOps + 1];
        // 初始化数组，不可到达的状态
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        //第一个元素不做替换的最小值
        dp[0][0] = arr1[0];
        //第一个元素做1, 2, 3, 4, 5...次替换，替换成arr2中的最小值，即第一个元素
        for (int ops = 1; ops <= maxOps; ops++) {
            dp[0][ops] = arr2[0];
        }

        for (int i = 1; i < arr1.length; i++) {
            for (int ops = 0; ops <= maxOps; ops++) {
                if (dp[i - 1][ops] != Integer.MAX_VALUE) {
                    // 不做替换（注意这里要跟 dp[i][ops] 比较取小值，因为inner loop替换当前这个可能会获得更小的值）
                    if (arr1[i] > dp[i - 1][ops]) {
                        dp[i][ops] = Math.min(dp[i][ops], arr1[i]);
                    }

                    // 可替换
                    if (ops + 1 <= maxOps) {
                        // 找第一个比dp[i-1][ops]大的值
                        int index = 0;
                        while (index < arr2.length && arr2[index] <= dp[i - 1][ops]) {
                            index++;
                        }
                        
                        // 如果找到了, 就更新dp值
                        if (index < arr2.length) {
                            dp[i][ops + 1] = Math.min(dp[i][ops + 1], arr2[index]);
                        }
                    }
                }
            }
        }

        for (int ops = 0; ops <= maxOps; ops++) {
            if (dp[arr1.length - 1][ops] != Integer.MAX_VALUE) {
                return ops;
            }
        }

        return -1;
    }
}