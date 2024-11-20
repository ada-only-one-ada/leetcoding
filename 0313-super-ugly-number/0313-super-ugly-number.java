class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] uglyNums = new long[n + 1];
        uglyNums[1] = 1;
        int[] indices = new int[primes.length];
        Arrays.fill(indices, 1);

        for (int num = 2; num <= n; num++) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                long curr = uglyNums[indices[i]] * primes[i];
                min = Math.min(min, curr);
            }

            uglyNums[num] = min;
            for (int i = 0; i < primes.length; i++) {
                long curr = uglyNums[indices[i]] * primes[i];
                if (curr == min) {
                    indices[i]++;
                }
            }
        }


        return (int)uglyNums[n];
    }
}