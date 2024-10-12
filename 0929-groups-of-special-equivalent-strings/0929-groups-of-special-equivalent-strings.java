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
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(oddFreq[i]).append(",");
            }
            sb.append("-");
            for (int i = 0; i < 26; i++) {
                sb.append(evenFreq[i]).append(",");
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }

        return map.size();
    }
}