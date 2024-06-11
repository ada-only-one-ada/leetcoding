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
        // 字符全部遍历完
        if (index == searchWord.length()) {
            return diff == 1 && node.isValid;
        }

        // 字典树是存在该字符, 接着找下一个
        if (node.children[searchWord.charAt(index) - 'a'] != null) {
            if (searchHelper(node.children[searchWord.charAt(index) - 'a'], searchWord, index + 1, diff)) {
                return true;
            }
        } 
        
        // 字典树不存在该字符, 且之前替换过了，返回false
        if (diff > 0) return false;

        // 字典树不存在该字符, 之前没有替换过
        // 枚举当前结点的所有子结点进行遍历，不能是当前的字符，不然字符一样不算替换
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
