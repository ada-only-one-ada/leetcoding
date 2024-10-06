class Solution {
    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word: words) {
            if (dfs(word, 0, 1)) {
                res.add(word);
            } else {
                insert(word);
            }
        }

        return res;
    }

    public boolean dfs(String word, int index, int numOfWords) {
        if (index == word.length() && numOfWords >= 2) {
            return true;
        }

        TrieNode node = root;
        for (int i = index; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            if (node.children[word.charAt(i) - 'a'].isValid) {
                if (dfs(word, i + 1, numOfWords + 1)) {
                    return true;
                }
            }
            node = node.children[word.charAt(i) - 'a'];
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