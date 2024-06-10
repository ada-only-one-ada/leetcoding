class TrieNode {
    TrieNode[] children;
    boolean isValid;
    public TrieNode() {
        children = new TrieNode[26];
        isValid = false;
    }
}

class MagicDictionary {
    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();    
    }

    public void insertNode(TrieNode root, String word) {
        TrieNode node = root;

        for (int index = 0; index < word.length(); index++) {
            if (node.children[word.charAt(index) - 'a'] == null) {
                node.children[word.charAt(index) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(index) - 'a'];
        }

        node.isValid = true;
    }
    
    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            insertNode(root, word);
        }
        
    }

    public boolean searchHelper(TrieNode node, String searchWord, int index, int diff) {
        if (index == searchWord.length()) {
            return diff == 1 && node.isValid;
        }

        if (node.children[searchWord.charAt(index) - 'a'] != null) {
            if (searchHelper(node.children[searchWord.charAt(index) - 'a'], searchWord, index + 1, diff)) {
                return true;
            }
        } 
            if (diff > 0) return false;
            for (int child = 0; child < 26; child++) {
                if (child != searchWord.charAt(index) - 'a' && node.children[child] != null) {
                    if (searchHelper(node.children[child], searchWord, index + 1, diff + 1)) {
                        return true;
                    }
                }
            }


        

        

        return false;
    }
    
    public boolean search(String searchWord) {
        return searchHelper(root, searchWord, 0, 0);
    }
}
