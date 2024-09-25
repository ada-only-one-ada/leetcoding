class Solution {
    Random random;
    int[] prefixSum;

    public Solution(int[] w) {
        random = new Random();
        prefixSum = new int[w.length];

        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int maxRange = prefixSum[prefixSum.length - 1];
        int randNum = random.nextInt(maxRange) + 1;

        int start = 0;
        int end = prefixSum.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // 如果当前mid的数字比它大，那么mid可能是第一个比它大的，也可能在mid之前
            if (randNum <= prefixSum[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}