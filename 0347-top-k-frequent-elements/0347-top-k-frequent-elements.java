class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[k];

        
        int max = Integer.MIN_VALUE;
        int maxKey = 0;
        int index = 0;
        
        while (index < k){
            for (int num: map.keySet()){
                if (map.get(num) > max){
                    maxKey = num;
                }
                max = Math.max(max, map.get(num));
            }
            
            res[index++] = maxKey;
            map.remove(maxKey);
            max = Integer.MIN_VALUE;
        }

        return res;
    }
}