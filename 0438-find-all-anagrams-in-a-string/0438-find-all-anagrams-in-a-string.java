class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int required = p.length();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (map.containsKey(curr) && map.get(curr) >= 1) {
                required--;
            }
            map.put(curr, map.getOrDefault(curr, 0) - 1);

            if (right - left + 1 == p.length()) {
                if (required == 0) res.add(left);

                char remove = s.charAt(left);
                if (map.get(remove) >= 0) required++;

                map.put(remove, map.get(remove) + 1);
                left++;
            }
        }

        return res;
    }
}