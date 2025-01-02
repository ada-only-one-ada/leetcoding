class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);

            map.put(letter, map.getOrDefault(letter, 0) + 1);
            
            while (map.size() < right - left + 1) {
                char removedLetter = s.charAt(left);
                map.put(removedLetter, map.get(removedLetter) - 1);
                if (map.get(removedLetter) == 0) {
                    map.remove(removedLetter);
                } 
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}