class Solution {
    public String simplifyPath(String path) {
        /* 
        . 表示当前路径
        .. 表示上一级路径
        // 或者 /// 相当于一个 /
        3个或以上的 . 为一个合法路径

        必须 / 开头
        不同的path 用 一个 / 隔开
        不能以 / 结束，除非是 root 
        3个以下的 . 不是合法路径

        /home//foo/ 
        ['home', '', 'foo']
        */
        String[] paths = path.split("/");
        Stack<String> stack = new Stack();

        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (paths[i].length() == 0) {
                continue;
            } else if (paths[i].equals(".") || paths[i].equals("..")) {
                continue;
            } else  {
                stack.push(paths[i]);
            } 
        }

        String res = "";

        while (!stack.isEmpty()) {
            res = stack.pop() + "/" + res;
        }
        
        if (res.length() > 1) return  "/" + res.substring(0, res.length() - 1);
        return "/" + res;
    }
}