class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int max = 0;
        for (int num: nums) {
            // start
            int currLen = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    currLen++;
                    num++;
                }
            }
            max = Math.max(max, currLen);
        }

        return max;
    }
}