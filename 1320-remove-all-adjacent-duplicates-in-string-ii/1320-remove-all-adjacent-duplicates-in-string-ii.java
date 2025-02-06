class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counts = new Stack();

        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                counts.push(1);
            } else if (sb.charAt(i) == sb.charAt(i-1)) {
                int total = counts.pop() + 1;

                if (total == k) {
                    // [start, end)
                    // aaa
                    // 012 (0,3)
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                } else {
                    counts.push(total);
                }
            }
        }

        return sb.toString();
    }
}