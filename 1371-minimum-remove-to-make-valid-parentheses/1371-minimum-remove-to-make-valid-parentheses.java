class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] parentheses = s.toCharArray();

        int open = 0;
        int close = 0;

        for (int i = 0; i < parentheses.length; i++) {
            char curr = parentheses[i];
            
            if (curr == '(') {
                open++;
            } else if (curr == ')') {
                if (close + 1 <= open) {
                    close++;
                } else {
                    parentheses[i] = ' ';
                }
            }
        }

        open = 0;
        close = 0;
        for (int i = parentheses.length - 1; i >= 0; i--) {
            char curr = parentheses[i];
            if (curr == ')') {
                close++;       
            } else if (curr == '(') {
                if (open + 1 <= close) {
                    open++;       
                } else {
                    parentheses[i] = ' ';
                }
            }
        }
        
        int index = 0;
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] != ' ') {
                parentheses[index] = parentheses[i];
                index++;
            } 
        }

        return new String(parentheses, 0, index);
    }
}