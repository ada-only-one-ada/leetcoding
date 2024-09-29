class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] parentheses = s.toCharArray();

        int open = 0;
        int close = 0;

        int left = 0;
        for (int right = 0; right < parentheses.length; right++) {
            char curr = parentheses[right];
            if (Character.isLetter(curr)) {
                left++;
            } else {
                if (curr == '(') {
                    open++;
                    left++;
                } else if (curr == ')') {
                    if (close + 1 <= open) {
                        left++;
                        close++;
                    } else {
                        parentheses[right] = ' ';
                    }
                }
            }
        }

        open = 0;
        close = 0;
        int right = parentheses.length - 1;
        for (int i = right; i >= 0; i--) {
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