class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int points: cardPoints) {
            sum += points;
        }   
        if (k == cardPoints.length) return sum;

        int len = cardPoints.length - k;
        // 长度为len的subarray，和最小

        int minSubarraySum = Integer.MAX_VALUE;
        int currSubarraySum = 0;

        int left = 0;
        for (int right = 0; right < cardPoints.length; right++) {
            currSubarraySum += cardPoints[right];

            if (right - left + 1 == len) {
                minSubarraySum = Math.min(minSubarraySum, currSubarraySum);

                currSubarraySum -= cardPoints[left];
                left++;
            }
        }

        return sum - minSubarraySum;
    }
}