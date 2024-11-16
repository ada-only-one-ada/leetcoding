class Solution {
    int[] res;
    int totalLen;

    public int[] constructDistancedSequence(int n) {
        totalLen = 2 * n - 1;
        res = new int[totalLen];
        boolean[] visited = new boolean[n + 1];
        backtracking(0, n, visited);
        return res;
    }

    private boolean backtracking(int index, int n, boolean[] visited) {
        if (index == totalLen) return true; // 完成整个序列
        if (res[index] != 0) return backtracking(index + 1, n, visited); // 当前位置已填充，跳过

        for (int num = n; num > 0; num--) {
            if (visited[num]) continue; // 数字已使用，跳过

            // 尝试放置数字num
            if (num == 1) {
                res[index] = 1;
                visited[num] = true;
                if (backtracking(index + 1, n, visited)) return true;
                // 回溯
                res[index] = 0;
                visited[num] = false;
            } else if (index + num < totalLen && res[index + num] == 0) { // 确保有空间放置num，并且配对位置也为空
                res[index] = num;
                res[index + num] = num;
                visited[num] = true;
                if (backtracking(index + 1, n, visited)) return true;
                // 回溯
                res[index] = 0;
                res[index + num] = 0;
                visited[num] = false;
            }
        }
        return false; // 无法放置任何数字
    }
}