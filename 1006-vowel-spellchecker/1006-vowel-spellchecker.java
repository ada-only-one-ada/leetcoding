class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        /* 
          1、有匹配的立刻返回
          2、优先检查大小写（有一个即可）
          3、再检查忽略元音
        */
        Set<String> perfect = new HashSet<>();
        Map<String, String> ignoreCaseMap = new HashMap<>();
        Map<String, String> ignoreVowelMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (String word: wordlist) {
            // 完全匹配的情况
            perfect.add(word);
 
            // 不匹配的情况
            String lowerCaseWord = word.toLowerCase();
            if (!ignoreCaseMap.containsKey(lowerCaseWord)) {
                ignoreCaseMap.put(lowerCaseWord, word);
            }

            StringBuilder tempIgnoreVowel = new StringBuilder();
            for (char letter: lowerCaseWord.toCharArray()) {
                if (set.contains(letter)) {
                    tempIgnoreVowel.append('-');
                } else {
                    tempIgnoreVowel.append(letter);
                }
            }

            if (!ignoreVowelMap.containsKey(tempIgnoreVowel.toString())) {
                ignoreVowelMap.put(tempIgnoreVowel.toString(), word);
            }
        }

        String[] res = new String[queries.length];
        Arrays.fill(res, "");

        for (int i = 0; i < queries.length; i++) {
            if (perfect.contains(queries[i])) {
                res[i] = queries[i];
            } else {
                String lowerWord = queries[i].toLowerCase();
                if (ignoreCaseMap.containsKey(lowerWord)) {
                    res[i] = ignoreCaseMap.get(lowerWord);
                } else {
                    StringBuilder noVowel = new StringBuilder();
                    for (char c: queries[i].toCharArray()) {
                        Character lowerC = Character.toLowerCase(c);
                        if (set.contains(lowerC)) {
                            noVowel.append('-');
                        } else {
                            noVowel.append(lowerC);
                        }
                    }
                    
                    if (ignoreVowelMap.containsKey(noVowel.toString())) {
                        res[i] = ignoreVowelMap.get(noVowel.toString());
                    }
                }
            }
        }

        return res;
    }
}