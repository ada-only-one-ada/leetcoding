class Solution {
    public int compress(char[] chars) {
        int filled = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[filled++] = chars[i - 1];
                if (count == 1) continue;

                String times = count + "";
                for (char time: times.toCharArray()) {
                    chars[filled++] = time;
                }

                count = 1;
            }
        }

        chars[filled++] = chars[chars.length - 1];
        if (count > 1) {
            String lastTimes = count + "";
            for (char time: lastTimes.toCharArray()) {
                chars[filled++] = time;
            }
        }

        return filled;
    }
}