class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int row = 0; row < numRows; row++) {
            sbs[row] = new StringBuilder();
        }

        int index = 0;
        while (index < s.length()) {
            for (int row = 0; row < numRows && index < s.length(); row++) {
                sbs[row].append(s.charAt(index));
                index++;
            }

            for (int row = numRows - 2; row >= 1 && index < s.length(); row--) {
                sbs[row].append(s.charAt(index));
                index++;
            }
        }

        String res = "";
        for (StringBuilder sb: sbs) {
            res += sb.toString();
        }
        return res;
    }
}