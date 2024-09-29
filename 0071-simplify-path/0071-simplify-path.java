class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        int numOfDots = 0;
        path += '/';

        for (int i = 0; i < path.length(); i++) {
            char curr = path.charAt(i);

            if (curr == '/') {
                // 重复的 '/' 可以跳过
                if (i > 0 && path.charAt(i - 1) == '/') continue; 

                // 全是 dots 且只有两个 dots 且 stack 不为空，上一级path可以移除
                if (numOfDots == 2 && numOfDots == temp.length() && !stack.isEmpty()) {
                    stack.pop();
                // 全是 dots 且 dots 数量多于 3个，或者不全是 dots的情况，加入 stack
                } else if (numOfDots >= 3 || numOfDots != temp.length()) {
                    stack.push(temp.toString());
                }

                temp.setLength(0);
                numOfDots = 0;
            } else if (curr != '/') {
                temp.append(curr);
                if (curr == '.') numOfDots++;
            } 
        }

        /*
        if (numOfDots == 2 && numOfDots == temp.length() && !stack.isEmpty()) {
            stack.pop();
        } else if (numOfDots >= 3 || numOfDots != temp.length()) {
            stack.push(temp.toString());
        }
        */

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            System.out.println(stack.peek() + " ");
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }

        return res.length() == 0? "/" : res.toString();
    }
}