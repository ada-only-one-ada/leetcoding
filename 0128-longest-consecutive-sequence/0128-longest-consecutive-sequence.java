class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int num: nums) {
            set.add(num);
        }

        for (int num: set) {
            // new beginning
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }
}