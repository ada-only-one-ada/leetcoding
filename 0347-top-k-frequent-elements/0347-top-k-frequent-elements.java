class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 1:3, 2:2, 3:1
        List[] bucket = new List[nums.length + 1];
        for (int num: map.keySet()) {
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int index = res.length - 1;
        for (int i = bucket.length - 1; i >= 0 & k > 0; i--) {
            if (bucket[i] == null) continue;

            List<Integer> list = bucket[i];
            for (int num: list) {
                res[index--] = num;
                k--;
            }
        }

        return res;
    }
}