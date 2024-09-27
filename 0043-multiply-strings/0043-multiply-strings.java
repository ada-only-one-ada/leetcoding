class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
      
        String res = "";
        int numOfZeros = 0;

        for (int i = num2.length() - 1; i >= 0; i--, numOfZeros += 1) {
            res = additionHelper(res, helper(num1, num2.charAt(i) - '0', numOfZeros));
        }

        return res;
    }

    public String helper(String num1, int val, int numOfZeros) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int currDigit = num1.charAt(i) - '0';
            int currSum = currDigit * val + prev;
            
            sb.append(currSum % 10);
            prev = currSum / 10;
        }  

        if (prev != 0) sb.append(String.valueOf(prev)); // 这里不能用type casting to (char)prev
        sb.reverse();
        for (int i = 0; i < numOfZeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }

    public String additionHelper(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        while (i1 >= 0 || i2 >= 0 || carry != 0) {
            int digit1 = i1 >= 0? s1.charAt(i1) - '0' : 0;
            int digit2 = i2 >= 0? s2.charAt(i2) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
         
            i1--;
            i2--;
        }

        return sb.reverse().toString();
    } 
}