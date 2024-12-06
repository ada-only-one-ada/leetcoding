class Solution {
    public int compress(char[] chars) {
        int repeated = 1;
        int filledIndex = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                repeated++;
            } else if (chars[i] != chars[i - 1]) {
                chars[filledIndex] = chars[i - 1];
                filledIndex++;
                if (repeated == 1) continue;
                
                String strRepeated = String.valueOf(repeated);
                for (int j = 0; j < strRepeated.length(); j++) {
                    chars[filledIndex++] = strRepeated.charAt(j);
                }

                repeated = 1;
            } 
        }

        chars[filledIndex] = chars[chars.length - 1];
        filledIndex++;
        if (repeated > 1) {
            String strRepeated = String.valueOf(repeated);
            for (int j = 0; j < strRepeated.length() && filledIndex < chars.length; j++) {
                chars[filledIndex++] = strRepeated.charAt(j);
            }
        }

        return filledIndex;
    }
}