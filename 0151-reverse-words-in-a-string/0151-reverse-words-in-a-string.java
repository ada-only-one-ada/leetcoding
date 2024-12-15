class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");          
        
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--){
            res.append(words[i] + ' ');
        }
        
        return res.toString().trim(); // remove last space
    }
}
// "    a  b"  = [a, b]; 
// "\\s+" means multiple empty space