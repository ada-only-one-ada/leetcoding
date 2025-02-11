class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            int target = num - k;

            if (map.containsKey(target)) {
                if (map.get(target) != -1) {
                    res++;
                    map.put(target, -1); 
                }
            }

            // 避免覆盖上面的target
            if (num == target && map.containsKey(target)) {
                map.put(num, map.get(target));
            } else {
                map.put(num, 2);
            }
        }

        return res;
    }
}