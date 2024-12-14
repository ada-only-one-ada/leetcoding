class Solution {
    public int[] plusOne(int[] digits) {
        int remain = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + remain;

            digits[i] = sum % 10;
            remain = sum / 10;
        }

        if (remain > 0) {
            digits = new int[digits.length + 1];
            digits[0] = remain;
        }

        return digits;
    }
}