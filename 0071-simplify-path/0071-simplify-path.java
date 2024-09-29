class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        int numOfDots = 0;

        for (int i = 0; i < path.length(); i++) {
            char curr = path.charAt(i);

            if (curr != '/') {
                temp.append(curr);
                if (curr == '.') numOfDots++;
            } else if (curr == '/') {
                if (i > 0 && path.charAt(i - 1) == '/') continue;

                if (numOfDots == temp.length()) {
                    if (numOfDots == 2 && !stack.isEmpty()) {
                        stack.pop();
                    } else if (numOfDots >= 3) {
                        stack.push(temp.toString());
                    }
                } else {
                    stack.push(temp.toString());
                }
                temp.setLength(0);
                numOfDots = 0;
            }
        }

        if (numOfDots == temp.length()) {
            if (numOfDots == 2 && !stack.isEmpty()) {
                stack.pop();
            } else if (numOfDots == 3) {
                stack.push("...");
            }
        } else {
            stack.push(temp.toString());
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            System.out.println(stack.peek() + " ");
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }

        return res.length() == 0? "/" : res.toString();
    }
}