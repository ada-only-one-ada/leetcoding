class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split("[\\s,.!?;']+");
        
        for (String word: words) {
            map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
        } 
    
        for (String ban: banned) {
            if (map.containsKey(ban.toLowerCase())) {
                map.remove(ban.toLowerCase());
            }
        }

        int maxFreq = 0;
        String maxFreqWord = "";
        for (String word: map.keySet()) {
            if (map.get(word) > maxFreq) {
                maxFreq = map.get(word);
                maxFreqWord = word;
            }
        }

        return maxFreqWord;
    }
}