class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] uglyNums = new long[n + 1]; // 存储丑数，从 1 到 n
        uglyNums[1] = 1; // 第一个丑数是1

        int[] indices = new int[primes.length]; // 存储每个质数对应的丑数index
        Arrays.fill(indices, 1); // 初始每个质数对应的丑数index都为1（第一个丑数）

        // dp 依次填充第 2 到 n 个丑数
        for (int num = 2; num <= n; num++) {
            long min = Long.MAX_VALUE;

            // 计算当前可用的最小丑数
            for (int i = 0; i < primes.length; i++) {
                long curr = uglyNums[indices[i]] * primes[i];
                if (curr < min) {
                    min = curr;
                }
            }

            // 更新丑数数组
            uglyNums[num] = min;

            // 更新所有生成了当前最小丑数的index
            // 这意味着下次该质数将乘以 uglyNums 中的下一个丑数
            // 比如质数7跟第一个丑数1相乘，贡献了下一个最小丑数，那么下一次质数7只能跟第二个丑数相乘
            for (int i = 0; i < primes.length; i++) {
                if (uglyNums[indices[i]] * primes[i] == min) {
                    indices[i]++;
                }
            }
        }
        
        return (int)uglyNums[n];
    }
}
