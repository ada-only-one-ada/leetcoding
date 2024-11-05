class Solution {
    public boolean isBalanced(String num) {
        int sumEven = 0;
        int sumOdd = 0;
        
        for (int i = 0; i < num.length(); i++) {
            int curr = Character.getNumericValue(num.charAt(i));
            if (i % 2 == 0) {
                sumEven += curr;
            } else {
                sumOdd += curr;
            }
        }

        return sumEven == sumOdd;
    }
}