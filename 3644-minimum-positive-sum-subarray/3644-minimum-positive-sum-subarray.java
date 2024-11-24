class Solution {
    public int minimumSumSubarray(List<Integer> nums, int minLength, int maxLength) {
        // 我们希望找到长度在 minLength 到 maxLength 之间的子数组，其和最小
        // 对于子数组 nums[start...end]，其和为 prefixSum[end + 1] - prefixSum[start]
        int res = Integer.MAX_VALUE;
        
        int[] prefixSum = new int[nums.size() + 1]; // 存储从list开始到当前位置的前缀和
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 存储各前缀和出现的次数
       
        for (int i = 1; i <= nums.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i - 1); // 更新前缀和数组
           
            if (i < minLength) continue; // 仅当子数组长度达到 minLength 时开始处理
            
            // 记录当前前缀和减去 minLength 前的前缀和次数，用于确保子数组长度至少为 minLength
            int currentPrefixSum = prefixSum[i - minLength];
            // 存储潜在的子数组起点前缀和
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
          
            // 查找当前前缀和下最接近（minimum）但小于（positive）的前缀和值
            Integer lowerPrefixSum = map.lowerKey(prefixSum[i]);
            if (lowerPrefixSum != null) res  = Math.min(res , prefixSum[i] - lowerPrefixSum);  // 如果找到，则尝试更新最小和

            // 如果当前 index 超过了 maxLength，需要移除不再需要的前缀和记录
            if (i >= maxLength) {
                int outdatedPrefixSum = prefixSum[i - maxLength];
                map.put(outdatedPrefixSum, map.get(outdatedPrefixSum) - 1);
                if (map.get(outdatedPrefixSum) == 0) {
                    map.remove(outdatedPrefixSum);
                } 
            }
        }

        // 如果 res  未被更新，返回 -1 表示没有找到符合条件的子数组
        return res  == Integer.MAX_VALUE ? -1 : res ;
    }
}
