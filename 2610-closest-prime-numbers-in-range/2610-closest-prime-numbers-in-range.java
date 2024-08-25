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

        int minGap = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};


        int prevPrime = -1;
        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                if (prevPrime != -1 && num - prevPrime < minGap) {
                    minGap = num - prevPrime;
                    res[0] = prevPrime;
                    res[1] = num;
                }
                
                prevPrime = num;
            }
        }
         
        return res;
    }
} 