class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        // 记录当前窗口有几对
        long pairs = 0; 

        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            int num = nums[end];
            // 当前数字之前出现过，那么当前数字可以和之前每一次的出现都组成一个新对，没出现过就是新加了0对
            pairs += map.getOrDefault(num, 0);
            
            // 将当前数字的出现次数增加1
            map.put(num, map.getOrDefault(num, 0) + 1);

            // 如果当前窗口内的对数达到或超过 k，就需要开始调整窗口的起始位置
            while (pairs >= k) {
                // [start, ...., end]
                // [start, ...., end, 1]
                // [start, ...., end, 1, 2]

                // 比如[start, 2, 3, 4, end, 6, 7]: 从 end 开始，之后的array一共有3个，7 - 4 = 3
                res += nums.length - end; 

                map.put(nums[start], map.get(nums[start]) - 1); 
                // 去掉了一个，还剩下有，说明之前是有贡献配对的
                // 如果去掉了一个，就没了，说明那个数字只有一个，不配对
                if (map.get(nums[start]) > 0) {
                    pairs -= map.get(nums[start]); 
                }

                start++;
            }
        }

        return res;
    }
}