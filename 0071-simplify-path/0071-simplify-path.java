class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        int numOfDots = 0;
        path += '/';

        for (int i = 0; i < path.length(); i++) {
            char curr = path.charAt(i);

            if (curr == '/') {
                if (i > 0 && path.charAt(i - 1) == '/') continue; 

                if (numOfDots == 2 && numOfDots == temp.length() && !stack.isEmpty()) {
                    stack.pop();
                } else if (numOfDots >= 3 || numOfDots != temp.length()) {
                    stack.push(temp.toString());
                }

                temp.setLength(0);
                numOfDots = 0;
            } else {
                temp.append(curr);
                if (curr == '.') numOfDots++;
            } 
        }

        StringBuilder res = new StringBuilder();
        for (String s: stack) {
            res.append("/" + s);
        }

        return res.length() == 0? "/" : res.toString();
    }
}