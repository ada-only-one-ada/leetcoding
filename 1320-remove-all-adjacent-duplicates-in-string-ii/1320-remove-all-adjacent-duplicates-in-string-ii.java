class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                stack.push(1);
            } else if (sb.charAt(i) == sb.charAt(i-1)) {
                int total = stack.pop() + 1;

                if (total == k) {
                   // len = k
                    //i - ?  +1 == k
                   // i+1-k=?
                    sb.delete(i+1-k, i+1);
                    i=i-k;
                } else {
                    stack.push(total);
                }
            }
        }


        return sb.toString();
    }
}