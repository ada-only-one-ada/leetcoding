class Solution {
    public int compress(char[] chars) {
        int filled = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else if (chars[i] != chars[i - 1]) {
                chars[filled] = chars[i - 1];
                filled++;
                if (count == 1) continue;

                String times = count + "";
                for (int index = 0; index < times.length(); index++) {
                    chars[filled++] = times.charAt(index);
                }

                count = 1;
            }
        }

        chars[filled] = chars[chars.length - 1];
        filled++;
        if (count > 1) {
            String lastTimes = count + "";
            for (int index = 0; index < lastTimes.length(); index++) {
                chars[filled++] = lastTimes.charAt(index);
            }
        }

        return filled;
    }
}