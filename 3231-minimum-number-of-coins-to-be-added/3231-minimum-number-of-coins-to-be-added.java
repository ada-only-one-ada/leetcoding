class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins); // 将硬币面值数组 coins 升序排序
        int count = 0; // 记录需要添加到数组中的硬币数量
        int currentSum = 0; // 当前可取得的最大金额

        for (int coin : coins) {
            while (currentSum + 1 < coin && currentSum < target) {
                // 如果当前可取得的最大金额加1小于当前硬币面值且小于目标金额
                // 则需要添加硬币面值为 currentSum + 1 的硬币
                currentSum += currentSum + 1;
                count++;
            }
            // 更新当前可取得的最大金额
            currentSum += coin;
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