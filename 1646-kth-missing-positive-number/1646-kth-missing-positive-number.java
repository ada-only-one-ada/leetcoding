class Solution {
    public int findKthPositive(int[] arr, int k) {
        // [6, 7, 10, 22]，找第1、2、3、4、5个missing的，直接返回
        if (k < arr[0]) return k;

        // 当前找到的总missing数，比如 [6, 7, 10, 22]，当前的total found就是 5 个
        int totalFound = arr[0] - 1;

        for (int i = 1; i < arr.length; i++) {
            int start = arr[i - 1];
            int end = arr[i];

            // 当前区间包含了几个数字
            int currFound = end - start - 1;

            // 如果说之前找到的总missing，加上当前区间的missing，大于等于k了
            // 说明我们要找的第 k 个 missing 数字肯定落在当前区间
            if (totalFound + currFound >= k) {
                // 返回当前区间的起点数字，再加上还差几个没找的（当前区间贡献，即去掉之前其他区间的贡献）
                return start + (k - totalFound);
            } 
                
            totalFound += currFound;
        }

        // 到最后都没找完，落在最后一个区间
        // 最后一个区间起点就是最后一个数字
        // 加上还差几个没找的
        return arr[arr.length - 1] + (k - totalFound);
    }
}