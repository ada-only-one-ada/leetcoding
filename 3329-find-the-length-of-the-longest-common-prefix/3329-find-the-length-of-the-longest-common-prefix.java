class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> allPrefixInArr1 = new HashSet<>();
        for (int num: arr1) {
            for (int currPrefix = num; currPrefix > 0; currPrefix /= 10) {
                allPrefixInArr1.add(currPrefix);
            }
        }

        int maxPrefix = Integer.MIN_VALUE;
        for (int num: arr2) {
            for (int currPrefix = num; currPrefix > 0; currPrefix /= 10) {
                if (allPrefixInArr1.contains(currPrefix)) {
                    maxPrefix = Math.max(maxPrefix, currPrefix);
                }
            }
        }

        if (maxPrefix == Integer.MIN_VALUE) return 0;
        return Integer.toString(maxPrefix).length();
    }
}