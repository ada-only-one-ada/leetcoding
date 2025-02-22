class Solution {
    // 使用 HashMap 存储每个单词及其最长链长度
    private Map<String, Integer> wordToChainLength = new HashMap<>();

    public int longestStrChain(String[] words) {
        // 初始化每个单词的最长链长度为0，表示尚未计算
        for (String word : words) {
            wordToChainLength.put(word, 0);
        }
        int maxLength = 0;
        // 遍历每个单词，使用DFS计算最长链
        for (String word : wordToChainLength.keySet()) {
            maxLength = Math.max(maxLength, dfs(word));
        }
        return maxLength;
    }

    private int dfs(String currentWord) {
        int currentLength = wordToChainLength.get(currentWord);
        if (currentLength > 0) {
            // 如果已经计算过这个单词的最长链长度，直接返回结果
            return currentLength;
        }
        int maxLengthToCurrent = 0;
        // 尝试删除当前单词的每一个字符，看是否能形成更长的链
        for (int i = 0; i < currentWord.length(); i++) {
            String prevWord = currentWord.substring(0, i) + currentWord.substring(i + 1);
            if (wordToChainLength.containsKey(prevWord)) {
                maxLengthToCurrent = Math.max(maxLengthToCurrent, dfs(prevWord));
            }
        }
        // 记录并返回包括当前单词的最长链长度
        wordToChainLength.put(currentWord, maxLengthToCurrent + 1);
        return maxLengthToCurrent + 1;
    }
}
