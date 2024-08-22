class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        int count = 0; 
        double currSum = 0;
        Arrays.sort(coins); // 对可用硬币排序，确保从小到大处理硬币
        int coinIndex = 0;

        // 对每个从 1 到 target 的目标金额 currTarget 进行迭代，检查是否能用现有硬币凑成该金额
        for (int currTarget = 1; currTarget <= target; currTarget++) {
            // 对于当前目标金额，检查是否可以用现有硬币 加上 之前的总和 来达到或者超过这个目标
            // 只要还有可用的硬币，且当前硬币值 小于 当前目标值，就可以拿来用
            while (coinIndex < coins.length && coins[coinIndex] <= currTarget) {
                currSum += coins[coinIndex];
                coinIndex++;
            }

            // 如果当前所有可用硬币加起来，都小于当前目标值，那么就是凑不到当前目标
            if (currSum < currTarget) {
                // 添加一个面值为 currTarget的硬币
                currSum += currTarget;
                count++;
            }
        }

        return count;
    }
}