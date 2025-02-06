class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int res = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)  +1);

            maxFreq = Math.max(maxFreq, map.get(c));

            while (right - left + 1 - maxFreq > k) {
                char removed = s.charAt(left);
                map.put(removed, map.get(removed) - 1);
                if (map.get(removed) == 0) map.remove(removed);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}