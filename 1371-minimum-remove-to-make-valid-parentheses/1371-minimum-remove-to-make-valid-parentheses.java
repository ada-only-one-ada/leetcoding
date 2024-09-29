class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] parentheses = s.toCharArray();

        // Track open and close parentheses
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
                    parentheses[i] = ' '; // Invalidate this ')' as no matching '('
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
                    parentheses[i] = ' '; // Invalidate this '(' as no matching ')'
                } 
            }
        }
        
        int left = 0;
        for (int right = 0; right < parentheses.length; right++) {
            if (parentheses[right] != ' ') {
                parentheses[left] = parentheses[right];
                left++;
            } 
        }

        return new String(parentheses, 0, left);
    }
}