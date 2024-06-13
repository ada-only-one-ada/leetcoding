class Node {
    Node[] children;
    boolean isValid;
    
    public Node() {
        children = new Node[26];
        isValid = false;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // 构建字典
        Node root = new Node();

        for (String validWord: dictionary) {
            Node node = root; // 存完一个单词之后需要reset node to root

            for (char c: validWord.toCharArray()) {
              
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node();
                }
                node = node.children[c - 'a'];
            }
            node.isValid = true;
        }

        // 找能替代的单词
        String[] searchWords = sentence.split(" ");
        String res = "";

        for (String searchWord: searchWords) {
            Node node = root;
            String prefix = "";

            for (char c: searchWord.toCharArray()) {
                // 如果没有当前单词，或者已经找到了一个合法的前缀，break
                if (node.children[c - 'a'] == null || node.isValid) {
                    break;
                // 否则，接着找下一个
                } else {
                    prefix += c;
                    node = node.children[c - 'a'];
                }
            }

            // 如果找完了这个单词都不valid，那么没有替代的，就还是原来的单词
            if (!node.isValid) {
                res += searchWord;
            // 合法的，就加上这个当前单词
            } else {
                res += prefix;
            }
        
            res += " ";
        }

        return res.toString().substring(0, res.length()-1);
    }
}