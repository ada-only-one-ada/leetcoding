class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word: words) {
            if (word.length() != pattern.length()) continue;

            boolean valid = true;
            boolean[] matched = new boolean[26];
           
            Map<Character, Character> wToP = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);

                if (wToP.containsKey(curr)) {
                    if (wToP.get(curr) != pattern.charAt(i)) {
                        valid = false;
                    }
                } else {
                    if (matched[pattern.charAt(i) - 'a']) {
                        valid = false;
                    } else {
                        wToP.put(curr, pattern.charAt(i));
                        matched[pattern.charAt(i) - 'a'] = true;
                    }
                }
                if (valid == false) break;
            }

            if (valid) res.add(word);
        }

        return res;
    }
}