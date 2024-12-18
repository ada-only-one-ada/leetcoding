class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s; // "AB", 1
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int row = 0; row < numRows; row++) {
            map.put(row, new ArrayList<>());
        }

        int currRow = 0;
        int i = 0;
        while (i < s.length()) {    
            while (i < s.length() && currRow < numRows) {
                char c = s.charAt(i);
                map.get(currRow).add(c);
                currRow++;
                i++;
            }

            currRow -= 2;
            while (i < s.length() && currRow >= 0) {
                char c = s.charAt(i);
                map.get(currRow).add(c);
                currRow--;
                i++;
            }
            currRow += 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            List<Character> list = map.get(row);
            if (list == null) continue;
            for (char c: list) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}