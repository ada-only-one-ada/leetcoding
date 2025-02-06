class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < sb.length(); i++) {
            // 如果是第一个字符或当前字符与前一个字符不同
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                stack.push(1);
            } else if (sb.charAt(i) == sb.charAt(i-1)) {
                // 如果当前字符与前一个字符相同，则弹出栈顶元素并加1
                int total = stack.pop() + 1;
                // 如果计数等于k，则删除这k个连续字符
                if (total == k) {
                    // len = k
                    //i - ? + 1 == k
                    // i+1-k=?
                    sb.delete(i+1-k, i+1);
                    // 删除字符后调整i的位置，回退到删除序列的前一个字符
                    i=i-k;
                } else {
                    // 如果计数不足k，则将新的计数重新压入栈中
                    stack.push(total);
                }
            }
        }


        return sb.toString();
    }
}