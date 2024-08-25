class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // 把 arr1 的所有前缀丢到一个哈希集合中，然后遍历 arr2 的所有前缀，统计在哈希集合中的最大公共前缀，最后拿到它的长度
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
                    // 取数值的最大值，因为数值越大长度越长
                    maxPrefix = Math.max(maxPrefix, currPrefix);
                }
            }
        }

        if (maxPrefix == Integer.MIN_VALUE) return 0;
        return Integer.toString(maxPrefix).length();
    }
}