class Solution {
    public String reverseWords(String s) {
        char[] words = s.toCharArray();

        // 去掉leading spaces
        int i = 0; 
        while (i < words.length && words[i] == ' ') i++;
        // 去掉trailing spaces
        int j = words.length - 1;
        while (j >= 0 && words[j] == ' ') j--;

        // 反转从 i 到 j 的字符
        reverse(words, i, j);

        // 内部一个个单词反转
        int start = i;
        for (int end = i; end <= j; end++) {
            // 当前遇到空格，反转前一个单词
            if (words[end] == ' ') {
                reverse(words, start, end - 1);
                // 移动start到当前的下一个index
                start = end + 1;
                // 可能会有连续的空格，继续移动start直到遇到一个字母（有效开始）
                while (start <= j && words[start] == ' ') start++;
            }
        }

        // 反转最后一个单个单词
        reverse(words, start, j);

        // 拼接结果 
        StringBuilder res = new StringBuilder();
        // loop 从 i 到 j 范围的字符
        for (int index = i; index <= j; index++) {
            // 如果已经粘贴过了一个空格，又遇到了空格，则跳过当前遇到的空格
            if (index > 0 && words[index] == ' ' && words[index-1] == ' ') continue;
            // 否则，粘贴到结果
            res.append(words[index]);
        }

        return res.toString();
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}