class Solution {
    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();

        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());

        for (String word: words) {
            if (dfs(word, 0)) {
                res.add(word);
            } else {
                insert(word);
            }
        }

        return res;
    }

    public boolean dfs(String word, int index) {
        if (index == word.length()) {
            return true;
        }

        TrieNode node = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                return false;
            }

            if (node.children[c - 'a'].isValid && dfs(word, i + 1)) {
                return true;
            }

            node = node.children[c - 'a'];
        }

        return false;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }

            node = node.children[c - 'a'];
        }

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