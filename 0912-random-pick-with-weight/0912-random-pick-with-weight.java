class Solution {
    int[] prefixSum;
    int[] w;

    public Solution(int[] w) {
        this.w = w;
        // [1, 3, 6] -> [1, 4, 10]
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i-1] + w[i];
        }
    }
    
    public int pickIndex() {
        int maxNum = prefixSum[prefixSum.length - 1];
        Random rand = new Random();

        int randNum = rand.nextInt(maxNum) + 1;
        for (int i = 0; i < prefixSum.length; i++) {
            if (randNum <= prefixSum[i]) {
                return i;
            }
        }

        return -1;
    }
}