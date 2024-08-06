class Solution {
    public String minWindow(String s, String t) {
        int start = -1;
        int end = -1;
        int minLen = s.length() + 1;
      
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int found = 0;
        Map<Character, Integer> count = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);

            // wrong: if (map.containsKey(curr) && count.get(curr) == map.get(curr))  can't use == here.
            //if (map.containsKey(curr) && count.get(curr).intValue() == map.get(curr).intValue())
            if (map.containsKey(c) && count.get(c).equals(map.get(c))) {
                found++;
            }

            while (found == map.size()) {
                if (right - left + 1 < minLen) {
                    start = left;
                    end = right;
                    minLen = right - left + 1;
                }

                char remove = s.charAt(left);
                if (map.containsKey(remove) && count.get(remove).equals(map.get(remove))) {
                    found--;
                }
                
                count.put(remove, count.get(remove) - 1);
                left++;
            }
        }

        return start == -1? "" : s.substring(start, end + 1);
    }
}