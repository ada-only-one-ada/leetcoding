class Solution {
    public int getLargestOutlier(int[] nums) {
        // [2,3,5,10]
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num: nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = Integer.MIN_VALUE;

        
        
        for (int outlier: nums) {
            int totalSum = sum - outlier;
            int halfSum = totalSum / 2;
            
            if (totalSum % 2 == 0 && map.containsKey(halfSum)) {
                if (outlier == halfSum && map.get(halfSum) > 1)  {
                    res = Math.max(res, outlier);
                } else if (outlier != halfSum) {
                    res = Math.max(res, outlier);
                }
            } 
        }

        return res;
    }
}