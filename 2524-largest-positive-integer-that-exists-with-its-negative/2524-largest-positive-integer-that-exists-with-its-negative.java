class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (num < 0) set.add(num);
        }

        int maxPos = -1;

        for (int num: nums) {
            if (num > 0 && set.contains(-num)) {
                maxPos = Math.max(maxPos, num);
            }
        }

        return maxPos > 0? maxPos : -1;
    }
}