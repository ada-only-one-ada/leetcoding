class Solution {
    public String minWindow(String s, String t) {
        int minLen = s.length() + 1;
        int start = 0;
        int end = s.length() - 1;

        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int toFind = map.size();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                
                if (map.get(c) == 0) {
                    toFind--;
                }
            }

            while (toFind == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }
                
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == 0) {
                        toFind++;
                    }

                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    left++;
                } else {
                    left++;
                }
            }
        }

        return minLen == s.length() + 1? "" : s.substring(start, end + 1);
    
    }
}