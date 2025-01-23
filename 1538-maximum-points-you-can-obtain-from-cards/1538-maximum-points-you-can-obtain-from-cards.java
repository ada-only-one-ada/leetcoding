class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // maximum leftmost + rightmost card
        // minimum middle subarray sum

        int window = cardPoints.length - k;
        int total = 0;
        int minSum = Integer.MAX_VALUE;
        
        int currSum = 0;
        int left = 0;
        for (int right = 0; right < cardPoints.length; right++) {
            total += cardPoints[right];

            currSum += cardPoints[right];
            if (right - left + 1 == window) {
                minSum = Math.min(minSum, currSum);

                currSum -= cardPoints[left];
                left++;
            }
        }

        if (k == cardPoints.length) return total;
        return total - minSum;
    }
}