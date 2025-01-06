class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int eachWordLen = words[0].length();
        int totalWordsLen = eachWordLen * words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) map.put(word, map.getOrDefault(word, 0) + 1);

        /*
        "barbarfootttooobarf", ["bar", "foo"]
        start = 0，初始window为 barbar，不符合。nextStart = 0 + 6 = 6,  bar bar foo ttt ooo bar f
        start = 1，初始window为 arbarf，不符合。nextStart = 1 + 6 = 7,  arb arf oot tto oob arf
        start = 2，初始window为 rbarfo，不符合。nextStart = 2 + 6 = 8,  rba rfo ott too oba rf
        start = 3，初始window为 barfoo，不符合。nextStart = 3 + 6 = 9,  bar foo ttt ooo bar f
        start = 4，初始window为 arfoot，不符合。nextStart = 4 + 6 = 10, arf oot tto oob arf
        start = 5，初始window为 rfoott，不符合。nextStart = 5 + 6 = 11, rfo ott too oba rf
        */

        for (int start = 0; start < eachWordLen; start++) {
            if (start + totalWordsLen > s.length()) break; 
    
            Map<String, Integer> count = new HashMap<>();
            int found = 0;
            String window = s.substring(start, start + totalWordsLen);
            for (int left = 0; left <= window.length() - eachWordLen; left += eachWordLen) {
                String substring = window.substring(left, left + eachWordLen);
                if (map.containsKey(substring)) {
                    count.put(substring, count.getOrDefault(substring, 0) + 1);
                    if (count.get(substring).equals(map.get(substring))) found++;
                }
            }
            if (found == map.size()) res.add(start);

            for (int nextStart = start + eachWordLen; nextStart <= s.length() - totalWordsLen; nextStart += eachWordLen) {
                String leftRemoved = s.substring(nextStart - eachWordLen, nextStart);
                String rightAdded = s.substring(nextStart + totalWordsLen - eachWordLen, nextStart + totalWordsLen);

                if (map.containsKey(leftRemoved)) {
                    if (count.get(leftRemoved).equals(map.get(leftRemoved))) found--;
                    count.put(leftRemoved, count.get(leftRemoved) - 1);
                    if (count.get(leftRemoved) == 0) count.remove(leftRemoved);
                }
                
                if (map.containsKey(rightAdded)) {
                    count.put(rightAdded, count.getOrDefault(rightAdded, 0) + 1);
                    if (count.get(rightAdded).equals(map.get(rightAdded))) found++;
                }

                if (found == map.size()) res.add(nextStart);
            }
        }

        return res;
    }
}