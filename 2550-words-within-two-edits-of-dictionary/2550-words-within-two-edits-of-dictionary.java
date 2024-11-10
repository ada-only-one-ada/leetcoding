class Node {
    Node[] children;
    boolean isValid;

    public Node() {
        this.children = new Node[26];
        this.isValid = false;
    }
}

class Solution {
    Node root = new Node();
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();

        buildDic(dictionary);
        for (String query: queries) {
            Node curr = root;
            if (check(query, 0, curr, 0)) {
                res.add(query);
            }
        }

        return res;
    }

    public void buildDic(String[] dictionary) {
        for (String word: dictionary) {
            // 注意这里每个新word都要重置回root
            Node curr = root;
            for (char letter: word.toCharArray()) {
                if (curr.children[letter - 'a'] == null) {
                    curr.children[letter - 'a'] = new Node();
                }
                curr = curr.children[letter - 'a'];
            }

            curr.isValid = true;
        }
    }

    public boolean check(String query, int edits, Node curr, int index) {
        if (edits >= 3) return false;

        if (index == query.length()) {
            return curr.isValid;
        }
        
        char letter = query.charAt(index);
        if (curr.children[letter - 'a'] != null) {
            // 注意这里不要直接 return check(...)，因为只要有一个对的，就是对的
            if (check(query, edits, curr.children[letter - 'a'], index + 1)) {
                return true;
            }
        }

        // 注意这里不要用else，因为也可以替换（不换白不换），走别的路
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                if (check(query, edits + 1, curr.children[i], index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}