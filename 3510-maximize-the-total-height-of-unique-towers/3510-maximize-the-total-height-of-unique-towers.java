class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);

        long res = maximumHeight[maximumHeight.length - 1];
        // 倒数第一个不变，因为我们让它最大
        for (int i = maximumHeight.length - 2; i >= 0; i--) {
            // 当前位置理想的最好(最大）是比它后一个小1
            // 但是不能超过当前位置设置的最大值
            maximumHeight[i] = Math.min(maximumHeight[i + 1] - 1, maximumHeight[i]);
            if (maximumHeight[i] <= 0) {
                return -1;
            }

            res += maximumHeight[i];
        }

        return res;
    }
}