class Solution {
    public int[] plusOne(int[] digits) {
        int left = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = left + digits[i];

            digits[i] = sum % 10;
            left = sum / 10;
        }

        if (left > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }
}