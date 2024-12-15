class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isValid = true;
    }
    
    public boolean search(String word) {
       return backtracking(word, 0, root);
    }

    public boolean backtracking(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isValid;
        if (node == null) return false;

        if (word.charAt(index) != '.') {
            if (node.children[word.charAt(index) - 'a'] == null) {
                return false;
            } else {
                return backtracking(word, index + 1, node.children[word.charAt(index) - 'a']);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] == null) continue;

                if (backtracking(word, index + 1, node.children[i])) {
                    return true;
                }
            }
        }

        return false;
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