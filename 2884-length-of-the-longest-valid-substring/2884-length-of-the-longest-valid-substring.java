class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>();
        set.addAll(forbidden);

        int res = 0;
        int left = 0;
        for (int right = 0; right < word.length(); right++) {
            for (int i = right; i >= left && i > right - 10; i--) {
                String temp = word.substring(i, right + 1);
                if (set.contains(temp)) {
                    left = i + 1;
                    break;
                }
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}