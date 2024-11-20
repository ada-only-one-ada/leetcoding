class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n]; // 存储第 n 个超级丑数
        int[] indexes = new int[primes.length]; // 每个质数的索引
        ugly[0] = 1; // 第一个丑数定义为 1

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            // 寻找当前可生成的最小丑数
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * ugly[indexes[j]]);
            }
            ugly[i] = min;
            // 更新所有质数的索引，只有当它们贡献了最小值时
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ugly[indexes[j]] == min) {
                    indexes[j]++;
                }
            }
        }

        return (int) ugly[n-1];
    }
}
