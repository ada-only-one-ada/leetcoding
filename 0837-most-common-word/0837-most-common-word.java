class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split("[\\s,.!?;']+");
        
        for (String word: words) {
            String lowerCaseWord = word.toLowerCase();
            map.put(lowerCaseWord, map.getOrDefault(lowerCaseWord, 0) + 1);
        } 
    
        for (String ban: banned) {
            String lowerCaseBan = ban.toLowerCase();
            if (map.containsKey(lowerCaseBan)) {
                map.remove(lowerCaseBan);
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