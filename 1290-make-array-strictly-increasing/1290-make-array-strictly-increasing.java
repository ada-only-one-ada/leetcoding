import java.util.Arrays;

public class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;  // arr1的长度
        Arrays.sort(arr2);   // 排序arr2以便后续操作
        int m = arr2.length;  // arr2的长度
        int maxOps = n;  // 最大操作次数，理论上每个元素都可能需要替换
        int[][] dp = new int[n][maxOps + 1];  // 动态规划数组

        // 初始化动态规划数组，用最大值填充表示无法到达的状态
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = arr1[0];  // 第一个元素不替换的情况
        for (int j = 1; j <= maxOps; j++) {
            dp[0][j] = arr2[0];  // 第一个元素替换成arr2中的最小元素
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= maxOps; j++) {
                if (dp[i-1][j] != Integer.MAX_VALUE) {
                    // 如果当前元素大于前一个元素，无需替换
                    if (arr1[i] > dp[i-1][j]) {
                        dp[i][j] = Math.min(dp[i][j], arr1[i]);
                    }
                    // 尝试替换当前元素为arr2中合适的元素
                    if (j + 1 <= maxOps) {
                        int pos = upperBound(arr2, dp[i-1][j]);
                        if (pos < m) {
                            dp[i][j + 1] = Math.min(dp[i][j + 1], arr2[pos]);
                        }
                    }
                }
            }
        }

        // 遍历最后一行，找到最小的可以形成递增序列的替换次数
        for (int j = 0; j <= maxOps; j++) {
            if (dp[n-1][j] != Integer.MAX_VALUE) {
                return j;
            }
        }
        return -1; // 如果没有可能的替换方案
    }

    // 辅助函数，用于找到arr2中大于给定值val的最小元素的位置
    private int upperBound(int[] arr, int val) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= val) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
