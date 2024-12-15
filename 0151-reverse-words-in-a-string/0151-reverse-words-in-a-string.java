class Solution {
    public String reverseWords(String s) {
        // 去掉leading spaces
        int i = 0; 
        while (i < s.length() && s.charAt(i) == ' ') i++;
        // 去掉trailing spaces
        
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') j--;

        // 把 s 的内容粘贴到 sb 中
        StringBuilder sb = new StringBuilder();
        for (int index = i; index <= j; index++) {
            // 忽略内部的多个空格
            if (index > 0 && s.charAt(index) == ' ' && s.charAt(index - 1) == ' ') continue;
            sb.append(s.charAt(index));
        }

        // 反转整个 sb
        reverse(sb, 0, sb.length() - 1);

        // 内部一个个单词反转
        int start = 0;
        for (int end = 0; end < sb.length(); end++) {
            // 当前遇到空格，反转前一个单词
            if (sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                // 移动start到当前的下一个index
                start = end + 1;
            }
        }

        // 反转最后一个单个单词
        reverse(sb, start, sb.length() - 1);
        return sb.toString();
    }

    public void reverse(StringBuilder sb, int start, int end) {
        // setCharAt(int index, char ch)
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
    }
}