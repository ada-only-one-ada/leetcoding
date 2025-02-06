class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                count++;
            } else if (chars[i] != chars[i-1]) {
                if (count == 1) {
                    chars[index++] = chars[i-1];
                } else if (count > 1) {
                    String times = String.valueOf(count);
                    chars[index++] = chars[i-1];
                    for (int j = 0; j < times.length(); j++) {
                        chars[index++] = times.charAt(j);
                    }

                    count = 1;
                }
            }
        }

        chars[index++] = chars[chars.length - 1];
        if (count > 1) {
            String times = String.valueOf(count);
            for (int i = 0; i < times.length(); i++) {
                chars[index++] = times.charAt(i);
            }
        }

        return index;
    }
}