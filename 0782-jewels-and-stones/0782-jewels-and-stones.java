class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c: jewels.toCharArray()) {
            set.add(c);
        }

        int res = 0;
        for (char c: stones.toCharArray()) {
            if (set.contains(c)) {
                res++;
            }
        }

        return res;
    }
}