class Solution {
    public int minOperations(int[] nums) {
        // 选三个一样的删掉
        // 选两个一样的删掉

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int num: map.keySet()) {
            int freq = map.get(num);
            if (freq < 2) return -1;

            int groupOfThree = freq / 3;
            res += groupOfThree;
            freq = freq % 3;

            if (freq == 2) {
                res++;
            } else if (freq == 1) {
                res++;
            }
        }

        return res;
    }
}