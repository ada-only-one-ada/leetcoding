class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int res = Integer.MIN_VALUE;

        for (int num: nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: nums) {
            int doubleSum = sum - num;

            if (doubleSum % 2 == 0) {
                int halfSum = doubleSum / 2;

                if (map.containsKey(halfSum)) {
                    if ((num == halfSum && map.get(num) > 1) || num != halfSum) {
                        res = Math.max(res, num);
                    }
                }
            }
        }

        return res;
    }
}
