class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: map.keySet()) {
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i > 0 && index < res.length; i--) {
            if (bucket[i] == null) continue;
            for (int num: bucket[i]) {
                res[index++] = num;
            }
        }

        return res;
    }
}