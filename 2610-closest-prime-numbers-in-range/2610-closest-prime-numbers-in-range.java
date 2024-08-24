class Solution {
    public int[] closestPrimes(int left, int right) {
        if (right - left < 2) return new int[]{-1, -1};

        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        // num = 2; num <= right; num++
        for (int num = 2; num * num <= right; num++) {
            if (isPrime[num]) {
                // multiple = 2; multiple * num <= right; multiple++
                for (int multiple = num; multiple * num <= right; multiple++) {
                    isPrime[num * multiple] = false;
                }
            }
        }

        int firstPrime = left;
        int lastPrime = right;

        int minGap = Integer.MAX_VALUE;
        int res1 = -1;
        int res2 = -1;

        int start = firstPrime;
        for (int end = firstPrime + 1; end <= lastPrime; end++) {
            if (!isPrime[end]) continue;

            while (start < end) {
                if (isPrime[start] && end - start < minGap) {
                    minGap = end - start;
                    res1 = start;
                    res2 = end;
                }

                start++;
            }
        }
         
        return new int[]{res1, res2};
    }
}