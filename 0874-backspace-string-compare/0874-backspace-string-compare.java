class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sSb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sSb.append(s.charAt(i));
            } else {
                if (sSb.length() > 0) {
                    sSb.deleteCharAt(sSb.length() - 1);
                }
            }
        }

        StringBuilder tSb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                tSb.append(t.charAt(i));
            } else {
                if (tSb.length() > 0) {
                    tSb.deleteCharAt(tSb.length() - 1);
                }
            }
        }

        return sSb.toString().equals(tSb.toString());
    }
}