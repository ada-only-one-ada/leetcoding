class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        
        int i = 0;
        // "     432"
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // all are space
        if (i == s.length()) return 0; 
        
        int sign = 1; 
        if (s.charAt(i) == '+' || s.charAt(i) == '-'){
            sign = s.charAt(i) == '+'? 1 : -1;
            i++;
        }
        
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        
        int res = 0;
        while(i < s.length()){
            int curr = s.charAt(i) - '0';    
            if (curr < 0 || curr > 9) break;  // not a digit

            // If the integer is out of the 32-bit signed integer range
            // then clamp the integer so that it remains in the range.
            if (res > MAX / 10 || (res == MAX / 10 && curr > MAX % 10)){
                return sign == 1? MAX: MIN;
            }
            
            res = res * 10 + curr;  
            i++;
        }

        return res * sign;      
    }
}

