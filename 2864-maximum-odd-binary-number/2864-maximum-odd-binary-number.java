class Solution {
    public String maximumOddBinaryNumber(String s) {
        int[] count = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count[0]++;
            } else if (c == '1') {
                count[1]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (count[1] >= 1) {
            sb.append("1");
            count[1]--;
        }
        
        while (count[0] >= 1) {
            sb.append("0");
            count[0]--;
        }
        
        while (count[1] >= 1) {
            sb.append("1");
            count[1]--;
        }
        
        
        return sb.reverse().toString();
    }
}