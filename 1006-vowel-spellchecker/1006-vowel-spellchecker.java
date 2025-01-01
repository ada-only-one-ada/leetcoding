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
            StringBuilder tempIgnoreCase = new StringBuilder();
            StringBuilder tempIgnoreVowel = new StringBuilder();
            for (char letter: word.toCharArray()) {
                // 全部变成小写
                char lowerCaseLetter = Character.toLowerCase(letter);

                tempIgnoreCase.append(lowerCaseLetter);

                if (set.contains(lowerCaseLetter)) {
                    tempIgnoreVowel.append('-');
                } else {
                    tempIgnoreVowel.append(lowerCaseLetter);
                }
            }

            // 加入第一个即可
            if (!ignoreCaseMap.containsKey(tempIgnoreCase.toString())) {
                ignoreCaseMap.put(tempIgnoreCase.toString(), word);
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