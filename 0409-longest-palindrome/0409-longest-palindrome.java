class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean single = false;
        for (int val: map.values()) {
            if (val % 2 == 0) {
                res += val;
            } else {
                if (single == false) {
                    res++;
                    single = true;
                }

                if (val >= 2) {
                    res += val / 2 * 2;
                }
            }
        }

        return res;
    }
}