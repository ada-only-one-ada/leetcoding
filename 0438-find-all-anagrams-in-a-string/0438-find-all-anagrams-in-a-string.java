class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int pCharNum = map.size();
        int toFind = map.size();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) - 1);
         
            if (map.get(c) == 0) {
                toFind--;
            }

            while (right - left + 1 == p.length()) {
                if (toFind == 0 ) {
                    res.add(left);
                }

                if (map.get(s.charAt(left)) == 0) toFind++;
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                
                left++;
            }
        }

        return res;
    }
}