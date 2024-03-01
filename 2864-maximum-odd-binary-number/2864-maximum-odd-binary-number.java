class Solution {
    public String maximumOddBinaryNumber(String s) {
        int zeros = 0;
        int ones = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (ones >= 1) {
            sb.append("1");
            ones--;
        }
        
        while (zeros >= 1) {
            sb.append("0");
            zeros--;
        }
        
        while (ones >= 1) {
            sb.append("1");
            ones--;
        }
        
        return sb.reverse().toString();
    }
}