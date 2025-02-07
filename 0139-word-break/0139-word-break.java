class TrieNode {
    boolean isWord; // 标记当前节点是否为一个单词的结尾
    TrieNode[] children; // 存储子节点

    TrieNode() {
        this.children = new TrieNode[26]; // 初始化大小为26的数组，对应英文字母a-z
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode(); // 创建Trie的根节点
        for (String word : wordDict) { // 遍历字典中的每个单词，构建Trie
            TrieNode curr = root;
            for (char c : word.toCharArray()) { // 遍历单词的每个字符
                int index = c - 'a'; // 计算字符对应的数组索引
                if (curr.children[index] == null) { // 如果该索引处没有节点
                    curr.children[index] = new TrieNode(); // 创建新的Trie节点
                }

                curr = curr.children[index]; // 移动到下一个节点
            }

            curr.isWord = true; // 标记单词结束的节点
        }

        boolean[] dp = new boolean[s.length() + 1]; // 动态规划数组
        dp[0] = true; // 初始化dp[0]为true，表示空字符串总是字典中的单词
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) { // 如果s的前i个字符可以被字典中的单词拆分
                TrieNode curr = root; // 从根节点开始
                for (int j = i; j < s.length(); j++) {
                    int index = s.charAt(j) - 'a'; // 计算字符对应的数组索引
                    if (curr.children[index] == null) { // 如果Trie中没有该字符
                        break; // 结束循环
                    }

                    curr = curr.children[index]; // 移动到下一个Trie节点
                    if (curr.isWord) { // 如果是单词的结尾
                        dp[j + 1] = true; // 更新dp数组，表示s的前j+1个字符可以被拆分
                    }
                }
            }
        }

        return dp[s.length()]; // 返回s能否被字典中的单词完全拆分
    }
}
