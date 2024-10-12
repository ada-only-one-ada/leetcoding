class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word: words) {
            int[] oddFreq = new int[26];
            int[] evenFreq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 != 0) {
                    oddFreq[word.charAt(i) - 'a']++;
                } else {
                    evenFreq[word.charAt(i) - 'a']++;
                }
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append(oddFreq[i]).append(",");
            }
            key.append("-");
            for (int i = 0; i < 26; i++) {
                key.append(evenFreq[i]).append(",");
            }

            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
            }
            map.get(key.toString()).add(word);
        }

        return map.size();
    }
}