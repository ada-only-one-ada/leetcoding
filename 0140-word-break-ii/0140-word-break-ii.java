class Solution {
    Trie root = new Trie(); 

    public List<String> wordBreak(String s, List<String> wordDict) {
        buildDictionary(wordDict);        

        // 使用 DFS 和备忘录（memoization）生成所有有效的句子组合
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, memo);
    }

    // DFS 方法：从字符串 s 的 index 位置开始，生成所有有效拆分的句子
    private List<String> dfs(String s, int index, Map<Integer, List<String>> memo) {
        // 如果 index 达到字符串末尾，返回包含空字符串的列表（用于后续拼接）
        if (index == s.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        // 如果该位置已经计算过，则直接返回结果，避免重复计算
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        List<String> sentences = new ArrayList<>();
        Trie node = root;
        // 从 index 位置开始，尝试所有可能的单词划分
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果在 Trie 中找不到匹配的路径，则直接退出当前循环
            if (node.children[c - 'a'] == null) break;

            node = node.children[c - 'a'];

            // 如果当前路径表示一个有效单词
            if (node.isValid) {
                // 截取从 index 到 i 的子串作为一个单词
                String word = s.substring(index, i + 1);

                // 递归获取从 i+1 开始的所有句子组合
                List<String> nextSentences = dfs(s, i + 1, memo);
                
                for (String next : nextSentences) {
                    // 如果 next 是空字符串，表示 word 已经是最后一个单词，不需要额外空格
                    if (next.equals("")) {
                        sentences.add(word);
                    } else {
                        sentences.add(word + " " + next);
                    }
                }
            }
        }

        // 将 index 位置的计算结果存入备忘录
        memo.put(index, sentences);
        return sentences;
    }

    public void buildDictionary(List<String> wordDict) {
        for (String word : wordDict) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isValid = true;
        }
    }
}

class Trie {
    boolean isValid; 
    Trie[] children;

    public Trie() {
        isValid = false;
        children = new Trie[26];
    }
}
