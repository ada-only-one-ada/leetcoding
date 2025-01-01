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
            perfect.add(word);
 
            String lowerCaseWord = word.toLowerCase();
            ignoreCaseMap.putIfAbsent(lowerCaseWord, word);

            StringBuilder tempIgnoreVowel = new StringBuilder(lowerCaseWord);
            for (int i = 0; i < tempIgnoreVowel.length(); i++) {
                if (set.contains(tempIgnoreVowel.charAt(i))) {
                    tempIgnoreVowel.setCharAt(i, '-');
                }
            }

            ignoreVowelMap.putIfAbsent(tempIgnoreVowel.toString(), word);
        }

        String[] res = new String[queries.length];
        Arrays.fill(res, "");

        for (int i = 0; i < queries.length; i++) {
            if (perfect.contains(queries[i])) {
                res[i] = queries[i];
            } else {
                String lowerCaseWord = queries[i].toLowerCase();
                if (ignoreCaseMap.containsKey(lowerCaseWord)) {
                    res[i] = ignoreCaseMap.get(lowerCaseWord);
                } else {
                    StringBuilder noVowel = new StringBuilder(lowerCaseWord);
                    for (int j = 0; j < noVowel.length(); j++) {
                        if (set.contains(noVowel.charAt(j))) {
                            noVowel.setCharAt(j, '-');
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