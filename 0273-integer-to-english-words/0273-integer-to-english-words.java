public class Solution {
    private static final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String convertThreeDigits(int num) {
        String result = "";

        if (num >= 100) {
            result += lessThan20[num / 100] + " Hundred ";
            num %= 100;
        }

        if (num >= 20) {
            result += tens[num / 10] + " ";
            num %= 10;
        }

        if (num != 0) result += lessThan20[num] + " ";

        return result;
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder res = new StringBuilder();
        
        int billion = (int)1e9, million = (int)1e6, thousand = 1000;
        
        if (num >= billion) {
            res.append(convertThreeDigits(num / billion)).append("Billion ");
            num %= billion;
        }
        
        if (num >= million) {
            res.append(convertThreeDigits(num / million)).append("Million ");
            num %= million;
        }
        
        if (num >= thousand) {
            res.append(convertThreeDigits(num / thousand)).append("Thousand ");
            num %= thousand;
        }
        
        res.append(convertThreeDigits(num));
        
        return res.toString().trim();
    }
}