class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> perfect = new HashSet<>();
        Map<String, String> deCaseMap = new HashMap<>();
        Map<String, String> deVowelMap = new HashMap<>();

        for (String word: wordlist) {
            perfect.add(word);
            String deCaseWord = deCase(word);
            deCaseMap.putIfAbsent(deCaseWord, word);
            deVowelMap.putIfAbsent(deVowel(deCaseWord), word);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (perfect.contains(queries[i])) {
                res[i] = queries[i];
                continue;
            }

            String deCaseWord = deCase(queries[i]);
            if (deCaseMap.containsKey(deCaseWord)) {
                res[i] = deCaseMap.get(deCaseWord);
                continue;
            }

            String deVowelWord = deVowel(deCaseWord);
            if (deVowelMap.containsKey(deVowelWord)) {
                res[i] = deVowelMap.get(deVowelWord);
                continue;
            }

            res[i] = "";
        }
        return res;
    }

    public String deCase(String word) {
        return word.toLowerCase();
    }

    public boolean isVowel(char letter) {
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
            return true;
        }
        return false;
    }

    public String deVowel(String word) {
        StringBuilder res = new StringBuilder(word);
        for (int i = 0; i < res.length(); i++) {
            if (isVowel(word.charAt(i))) {
                res.setCharAt(i, '-');
            }
        }
        return res.toString();
    }
}