class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int toFind = map.size();
        int start = 0;
        int end = s.length() + 1;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) - 1);

            if (map.get(c) == 0) {
                toFind--;
            }

            while (toFind == 0) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }

                if (map.get(s.charAt(left)) == 0) {
                    toFind++;
                }

                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                left++;
            }            
        }

        return end == s.length() + 1? "" :s.substring(start, end + 1);
    }
}