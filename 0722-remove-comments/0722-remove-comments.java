class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder resLine = new StringBuilder();
        boolean inBlock = false;
        
        for (String line: source) {
            // 一行行遍历
            for (int i = 0; i < line.length(); i++) {
                // 非代码块，检查接下来是否开始代码块
                if (!inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++; // 跳过 *
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        i++; // 跳过 /
                        break; // 忽略本行剩余部分
                    } else {
                        // 不是注释的情况，将字符添加到新行
                        resLine.append(line.charAt(i));
                    }
                // 代码块，检查接下来是否结束代码块
                } else if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++; // 跳过 /
                    }
                }
            }

            // 当前行遍历完，非注解块，且有内容，说明是有效行，加入结果
            if (!inBlock && resLine.length() > 0) {
                res.add(resLine.toString());
                resLine.setLength(0);
            }
        }

        return res;
    }
}