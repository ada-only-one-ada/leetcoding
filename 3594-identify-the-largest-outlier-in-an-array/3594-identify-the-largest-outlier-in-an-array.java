class Solution {
    public int getLargestOutlier(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        for (int num: nums) {
            int doubleSum = sum - num;
            if (doubleSum % 2 == 0 && map.containsKey(doubleSum / 2)) {
                if (num == doubleSum / 2 && map.get(num) >= 2) {
                    res = Math.max(res, num);
                } else if (num != doubleSum / 2) {
                    res = Math.max(res, num);
                }
            }
        }

        return res;
    }
}