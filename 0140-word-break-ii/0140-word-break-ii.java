import java.util.*;

class Solution {
    Trie root = new Trie(); // 初始化 Trie 树根节点

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 根据单词字典构建 Trie 树
        buildDictionary(wordDict);

        // 使用动态规划判断字符串 s 是否可以拆分成字典中的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 空字符串可以被拆分
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) { // 如果 s 的前 i 个字符可以拆分
                Trie node = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    // 如果当前字符在 Trie 中没有对应的子节点，则跳出循环
                    if (node.children[c - 'a'] == null) break;
                    node = node.children[c - 'a'];
                    // 如果从 i 到 j 的子串是一个有效单词，则标记 dp[j+1] 为 true
                    if (node.isValid) {
                        dp[j + 1] = true;
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        // 如果整个字符串无法拆分，则返回空列表
        if (!dp[s.length()]) {
            return res;
        }

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

    // 根据单词字典构建 Trie 树
    public void buildDictionary(List<String> wordDict) {
        for (String word : wordDict) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            // 标记该路径代表一个有效单词
            node.isValid = true;
        }
    }
}

// Trie 树的基本节点定义
class Trie {
    boolean isValid; // 是否为有效单词的结束标志
    Trie[] children; // 子节点数组，对应 26 个小写字母

    public Trie() {
        isValid = false;
        children = new Trie[26];
    }
}
