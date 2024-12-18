class Solution {
    public String convert(String s, int numRows) {      
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int row = 0; row < numRows; row++){
            sb[row] = new StringBuilder();
        }
        
        int index = 0;
        while (index < s.length()){
            for (int row = 0; row < numRows && index < s.length(); row++){
                sb[row].append(s.charAt(index));
                index++;
            }
            
            for (int row = numRows-2; row >= 1 && index < s.length(); row--){
                sb[row].append(s.charAt(index));
                index++;
            }
        }
        
        for (int row = 1; row < numRows; row++){
            sb[0].append(sb[row]);
        }

        return sb[0].toString();
    }
}