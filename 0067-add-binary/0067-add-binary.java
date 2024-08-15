class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
       
        while (i >= 0 || j >= 0) {
            int numA = 0;
            int numB = 0;
            if (i >= 0) numA = Character.getNumericValue(a.charAt(i));
            if (j >= 0) numB = Character.getNumericValue(b.charAt(j));
            int sum = remainder + numA + numB;

            res.append(sum % 2);
            remainder = sum / 2;
            i--;
            j--;
        }

        if (remainder != 0) {
            res.append(1);
        }

        return res.reverse().toString();
    }
}