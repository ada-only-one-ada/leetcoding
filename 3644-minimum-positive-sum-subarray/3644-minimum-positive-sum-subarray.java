class Solution {
    public int minimumSumSubarray(List<Integer> nums, int minLength, int maxLength) {
        // 初始化结果变量为最大整数，用于找到最小子数组和
        int minimumSum = Integer.MAX_VALUE;

        // prefixSum 数组用于存储从列表开始到当前位置的前缀和
        int[] prefixSum = new int[nums.size() + 1];
     
        // 使用 TreeMap 存储各前缀和出现的次数，方便快速查找
        TreeMap<Integer, Integer> prefixCountMap = new TreeMap<>();
        for (int j = 1; j <= nums.size(); j++) {
            // 通过累加前一个前缀和与当前值来更新前缀和数组
            prefixSum[j] = prefixSum[j - 1] + nums.get(j - 1);
            // 仅当子数组长度达到 minLength 时开始处理
            if (j < minLength) {
                continue;
            }
            // 记录当前前缀和减去 minLength 前的前缀和次数
            prefixCountMap.merge(prefixSum[j - minLength], 1, Integer::sum);

            // 查找当前前缀和下最接近但小于的前缀和值
            Integer lowerPrefixSum = prefixCountMap.lowerKey(prefixSum[j]);
            // 如果找到，则尝试更新最小和
            if (lowerPrefixSum != null) {
                minimumSum = Math.min(minimumSum, prefixSum[j] - lowerPrefixSum);
            }

            // 如果当前索引超过了 maxLength，需要移除不再需要的前缀和记录
            if (j >= maxLength) {
                int outdatedPrefixSum = prefixSum[j - maxLength];
                int count = prefixCountMap.get(outdatedPrefixSum);
                if (count == 1) {
                    prefixCountMap.remove(outdatedPrefixSum);
                } else {
                    prefixCountMap.put(outdatedPrefixSum, count - 1);
                }
            }
        }

        // 如果 minimumSum 未被更新，返回 -1 表示没有找到符合条件的子数组
        return minimumSum == Integer.MAX_VALUE ? -1 : minimumSum;
    }
}
