class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;

        int paid = 0;
        for (int[] bracket: brackets) {            
            int taxLimit = Math.min(income, bracket[0]);
            double taxRate = (double) bracket[1] / 100;

            int currPaid = taxLimit - paid;
            res += currPaid * taxRate;
            paid += currPaid;

            if (paid == income) break;
        }

        return res;
    }
}