class Solution {
    public int minimumSumSubarray(List<Integer> nums, int minLength, int maxLength) {
        int res = Integer.MAX_VALUE;
        
        int[] prefixSum = new int[nums.size() + 1]; // 存储从list开始到当前位置的前缀和
        TreeMap<Integer, Integer> prefixCountMap = new TreeMap<>(); // 存储各前缀和出现的次数
       
        for (int i = 1; i <= nums.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i - 1); // 更新前缀和数组
           
            if (i < minLength) continue; // 仅当子数组长度达到 minLength 时开始处理
            
            // 记录当前前缀和减去 minLength 前的前缀和次数
            int currentPrefixSum = prefixSum[i - minLength];
            if (prefixCountMap.containsKey(currentPrefixSum)) {
                prefixCountMap.put(currentPrefixSum, prefixCountMap.get(currentPrefixSum) + 1);
            } else {
                prefixCountMap.put(currentPrefixSum, 1);
            }

            // 查找当前前缀和下最接近但小于的前缀和值
            Integer lowerPrefixSum = prefixCountMap.lowerKey(prefixSum[i]);
            // 如果找到，则尝试更新最小和
            if (lowerPrefixSum != null) res  = Math.min(res , prefixSum[i] - lowerPrefixSum);

            // 如果当前 index 超过了 maxLength，需要移除不再需要的前缀和记录
            if (i >= maxLength) {
                int outdatedPrefixSum = prefixSum[i - maxLength];
                int count = prefixCountMap.get(outdatedPrefixSum);
                
                if (count == 1) {
                    prefixCountMap.remove(outdatedPrefixSum);
                } else {
                    prefixCountMap.put(outdatedPrefixSum, count - 1);
                }
            }
        }

        // 如果 res  未被更新，返回 -1 表示没有找到符合条件的子数组
        return res  == Integer.MAX_VALUE ? -1 : res ;
    }
}
