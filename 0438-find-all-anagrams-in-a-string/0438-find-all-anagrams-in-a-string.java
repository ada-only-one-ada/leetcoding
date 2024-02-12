class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int found = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            if (map.containsKey(curr) && map.get(curr) > 0) {
                found++;
            }
            map.put(curr, map.getOrDefault(curr, 0) - 1);

            if (right - left + 1 == p.length()) {
                if (found == p.length()) {
                    res.add(left);
                }

                if (map.get(s.charAt(left)) >= 0) found--;
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                left++;
            }
        }

        return res;
    }
}