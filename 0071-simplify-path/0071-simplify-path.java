class Solution {
    public String simplifyPath(String path) {
        // String[] paths = path.split('/');
        // error: incompatible types: char cannot be converted to String
        String[] paths = path.split("/");
        Stack<String> stack = new Stack();

        for (int i = 0; i < paths.length; i++) {
            // String currPath = paths[i].trim();
            String currPath = paths[i];
            // 比如连续的'//'，split以后会变成[]空的
            // 妈的，string用双引号，草！
            if (currPath.length() == 0 || currPath.equals(".")) continue;

            if (currPath.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else {
                if (!currPath.equals("..")) {
                    stack.push(currPath);
                }
            }
        }
        
        return "/" + String.join("/", stack);
    }
}