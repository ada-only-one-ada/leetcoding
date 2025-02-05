class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        int sum = digits[index] + 1;
        int left = sum / 10;
        int digit = sum % 10;
        digits[index] = digit;
        index--;

        if (left == 0) return digits;

        while (index >= 0) {
            sum = digits[index] + left;
            digit = sum % 10;
            digits[index--] = digit;
            left = sum / 10;
        }

        if (left > 0) {
            int[] extra = new int[digits.length + 1];
            extra[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                extra[i+1] = digits[i];
            }
            return extra;
        }

        return digits;
    }
}