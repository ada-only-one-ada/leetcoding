class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num: map.keySet()){
            if (bucket[map.get(num)] == null){
                bucket[map.get(num)] = new ArrayList<>();
            }

            bucket[map.get(num)].add(num);
        }
        
        List<Integer> list = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0; i--){
            if (k > 0 && bucket[i] != null){
                list.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        int i = 0;
        int[] res = new int[list.size()];
        for (int num: list){
            res[i++] = num;
        }

        return res;
    }
}