class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = 0;
            int digitB = 0;
            if (i >= 0) digitA = Character.getNumericValue(a.charAt(i));
            if (j >= 0) digitB = Character.getNumericValue(b.charAt(j));

            int sum = carry + digitA + digitB;
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}