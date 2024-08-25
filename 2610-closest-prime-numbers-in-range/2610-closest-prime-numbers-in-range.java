class Solution {
    public int[] closestPrimes(int left, int right) {
        if (right - left <= 2) return new int[]{-1, -1};

        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        
        for (int num = 2; num < right; num++) {
            if (isPrime[num]) {
                for (int multiple = 2; multiple * num < right; multiple++) {
                    isPrime[num * multiple] = false;
                }
            }
        }

        int firstPrime = left + 1;
        while (firstPrime < isPrime.length && !isPrime[firstPrime]) {
            firstPrime++;
        }

        int lastPrime = right - 1;
        while (lastPrime >= 0 && !isPrime[lastPrime]) {
            lastPrime--;
        }

        if (lastPrime <= firstPrime) {
            return new int[]{-1, -1}; 
        }

        int minGap = Integer.MAX_VALUE;
        int res1 = -1;
        int res2 = -1;

        int start = firstPrime;
        for (int end = start+ 1; end < lastPrime; end++) {
            if (!isPrime[end]) continue;

            if (end - start < minGap) {
                res1 = start;
                res2 = end;
            }
        }
         
        return new int[]{res1, res2};
    }
}