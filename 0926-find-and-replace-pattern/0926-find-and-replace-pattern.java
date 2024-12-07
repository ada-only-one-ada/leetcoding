class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put(pattern.charAt(0), 0);

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                map.put(c, map.size());
                sb.append(map.get(c));
            }
            sb.append(".");
        }

        for (String word: words) {
            if (word.length() != pattern.length()) continue;

            StringBuilder wordPattern = new StringBuilder();
            Map<Character, Integer> wordMap = new HashMap<>();
            wordMap.put(word.charAt(0), 0);

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (wordMap.containsKey(c)) {
                    wordPattern.append(wordMap.get(c));
                } else {
                   wordMap.put(c, wordMap.size());
                   wordPattern.append(wordMap.get(c));
                }
                wordPattern.append(".");
            }

            if (wordPattern.toString().equals(sb.toString())) {
                res.add(word);
            }
        }

        return res;
    }
}