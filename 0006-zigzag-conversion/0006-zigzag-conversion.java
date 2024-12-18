class Solution {
    public String convert(String s, int numRows) {
        // 初始化一个StringBuilder数组，每个元素对应Zigzag的一行
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int row = 0; row < numRows; row++) {
            sb[row] = new StringBuilder();
        }
        
        int index = 0; // 用于遍历字符串`s`的索引
        
        // 外层循环，遍历整个字符串
        while (index < s.length()) {
            // 第一个内部循环，按顺序向下填充每一行，直到最后一行或字符串结束
            for (int row = 0; row < numRows && index < s.length(); row++) {
                sb[row].append(s.charAt(index)); // 将当前字符加到对应行的StringBuilder
                index++; // 移动到下一个字符
            }
            
            // 第二个内部循环，从倒数第二行向上填充，直到第二行或字符串结束
            for (int row = numRows-2; row >= 1 && index < s.length(); row--) {
                sb[row].append(s.charAt(index)); // 将当前字符加到对应行的StringBuilder
                index++; // 移动到下一个字符
            }
        }
        
        // 将所有行的字符串合并到第一行的StringBuilder
        for (int row = 1; row < numRows; row++) {
            sb[0].append(sb[row]);
        }

        return sb[0].toString(); // 返回合并后的字符串
    }
}
