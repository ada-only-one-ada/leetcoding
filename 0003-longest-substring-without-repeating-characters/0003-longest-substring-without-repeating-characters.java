class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (map.containsKey(c) && map.get(c) == 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            map.put(c, map.getOrDefault(c, 0) + 1);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}