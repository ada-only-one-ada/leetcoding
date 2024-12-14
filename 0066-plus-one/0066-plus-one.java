class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] res = new int[digits.length];

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            int curr = sum % 10;
            res[i] = curr;
        }

        if (carry == 1) {
            res = new int[res.length + 1]; 
            res[0] = 1;
        }

        return res;
    }
}