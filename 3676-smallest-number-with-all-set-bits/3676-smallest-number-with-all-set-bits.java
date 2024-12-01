class Solution {
    public int smallestNumber(int n) {
        String b = Integer.toBinaryString(n);
        
        int len = b.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            sb.append("1");
        }
            
        return Integer.parseInt(sb.toString(), 2);
    }
}