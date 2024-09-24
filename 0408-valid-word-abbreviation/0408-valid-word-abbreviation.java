class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        StringBuilder value = new StringBuilder();

        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
           
            if (Character.isDigit(c)) {
                value.append(c);
            } else if (Character.isLetter(c)){ 
                if (value.length() != 0) {
                    if (value.charAt(0) == '0') return false;
                    index += Integer.valueOf(value.toString());
                    value.setLength(0);
                } 
                if (index >= word.length()) {
                    return false;
                }
                
                if (word.charAt(index) != c) {
                    return false;
                } else {
                    index++;
                    value.setLength(0);
                }
            }
        }

        if (value.length() != 0) {
            if (value.charAt(0) == '0') {
                return false;
            }
            index += Integer.valueOf(value.toString());
        }
        
        if (index != word.length()) return false;
        return true;
    }
}