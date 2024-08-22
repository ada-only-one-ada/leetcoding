class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins); // 将硬币面值数组 coins 升序排序
        int count = 0; // 记录需要添加的新硬币数量
        int currentSum = 0; // 当前可取得的最大金额

        for (int coin : coins) {
            while (coin > currentSum + 1) {
                // 要获取的 当前目标金额 是 currentSum + 1
                // 如果当前硬币面值 大于 当前目标金额
                // 说明 下一个目标金额，无法通过 currentSum 和当前硬币凑到，因为太大了
                // 则需要添加硬币面值为 当前目标金额 的硬币
                currentSum += currentSum + 1;
                count++;
            }

            currentSum += coin; // 更新当前可取得的最大金额
            
            if (currentSum >= target) {
                // 如果当前可取得的最大金额已经大于或等于目标金额，则无需继续遍历硬币
                break;
            }
        }

        // 继续添加硬币直到当前可取得的最大金额大于等于目标金额
        while (currentSum < target) {
            currentSum += currentSum + 1;
            count++;
        }

        return count;
    }
}