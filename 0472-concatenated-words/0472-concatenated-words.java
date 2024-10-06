class Solution {
    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();

        // 把短的先加入字典，这样可以一边遍历一边判断
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        for (String word: words) {
            if (dfs(word, 0, 0)) {
                res.add(word);
            } else {
                // 不是concatenated单词，加入字典，比如cat，dod
                insert(word);
            }
        }

        return res;
    }

    public boolean dfs(String word, int index, int numOfValidWords) {
        // 有效单词大于2个
        if (index == word.length() && numOfValidWords >= 2) {
            return true;
        }

        TrieNode node = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }

            if (node.children[c - 'a'].isValid) {
                if (dfs(word, i + 1, numOfValidWords + 1)) {
                    return true;
                }
            }
            node = node.children[c - 'a'];
        }

        return false;
    }

    // 构建字典树
    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        // 设为有效单词
        node.isValid = true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isValid;

    public TrieNode() {
        children = new TrieNode[26];
        isValid = false;
    }
}