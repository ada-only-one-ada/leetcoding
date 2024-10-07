class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int marker = digits.length; // 这将标记数字停止递增的位置。

        // 从倒数第一个数字开始向数字的开头移动。
        for (int i = digits.length - 1; i > 0; i--) {
            // 如果当前数字小于前一个数字，表明不再递增。
            if (digits[i] < digits[i - 1]) {
                marker = i; // 更新标记到当前位置。
                digits[i - 1]--; // 将前一个数字减一。
            }
        }

        // 将标记之后的所有数字替换为'9'，使数字尽可能大。
        for (int i = marker; i < digits.length; i++) {
            digits[i] = '9';
        }

        // 将字符数组重新转换回字符串，然后转换为整数。
        return Integer.parseInt(new String(digits));
    }
}
