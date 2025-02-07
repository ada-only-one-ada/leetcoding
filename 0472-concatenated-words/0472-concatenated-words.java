class Solution {
    Trie root = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

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

        Trie node = root;
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

class Trie {
    boolean isValid;
    Trie[] children;

    public Trie() {
        isValid = false;
        children = new Trie[26];
    }
}