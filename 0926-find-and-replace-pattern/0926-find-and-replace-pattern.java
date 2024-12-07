class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (word.length() != pattern.length()) continue;

            boolean valid = true; 
            boolean[] matched = new boolean[26]; // 记录模式中的每个字符是否已被映射

            Map<Character, Character> wToP = new HashMap<>(); // 单词到模式的映射
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i); 

                // 如果当前字符已存在映射
                if (wToP.containsKey(curr)) {
                    // 如果当前字符映射与模式字符不匹配，则标记为不匹配并中断
                    if (wToP.get(curr) != pattern.charAt(i)) {
                        valid = false;
                        break; // break 语句是用来跳出最近的那个 for 循环
                    }
                } else { // 如果当前字符不存在映射
                    // 如果模式字符已被其他单词字符映射，则标记为不匹配并中断
                    if (matched[pattern.charAt(i) - 'a']) {
                        valid = false;
                        break;
                    } else { // 建立新的映射关系
                        wToP.put(curr, pattern.charAt(i));
                        matched[pattern.charAt(i) - 'a'] = true; // 标记该模式字符已被映射
                    }
                }
            }

            // 如果当前单词匹配模式，则加入结果列表
            if (valid) res.add(word);
        }

        return res;
    }
}
