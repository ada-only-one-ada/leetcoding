class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        int count = 0; 
        double currSum = 0;
        Arrays.sort(coins); 
        int coinIndex = 0;

        for (int currTarget = 1; currTarget <= target; currTarget++) {
            while (coinIndex < coins.length && coins[coinIndex] <= currTarget) {
                currSum += coins[coinIndex];
                coinIndex++;
            }

            if (currSum < currTarget) {
                currSum += currTarget;
                count++;
            }
        }

        return count;
    }
}