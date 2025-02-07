class Trie {
    boolean isValid;
    Trie[] children;

    public Trie() {
        isValid = false;
        children = new Trie[26];
    }
}

class Solution {
    Trie root = new Trie();

    public boolean wordBreak(String s, List<String> wordDict) {
        buildDictionary(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                Trie node = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (node.children[c - 'a'] == null) {
                        break;
                    }
                    
                    node = node.children[c - 'a'];
                    if (node.isValid) {
                        dp[j + 1] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    public void buildDictionary(List<String> wordDict) {
        for (String word: wordDict) {
            Trie node = root;
            for (char c: word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isValid = true;
        }
    }
}