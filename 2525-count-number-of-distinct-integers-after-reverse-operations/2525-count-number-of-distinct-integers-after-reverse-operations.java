class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
            set.add(getReversed(num));
        }

        return set.size();
    }

    public int getReversed(int num) {
        // 531 -> 135
        // 0 * 10 + 1 = 1
        // 1 * 10 + 3 = 13
        // 13 * 10 + 5 = 135

        int prev = 0;
        while (num > 0) {
            prev = prev * 10 + (num % 10);
            num /= 10;
        }

        return prev;
    }
}