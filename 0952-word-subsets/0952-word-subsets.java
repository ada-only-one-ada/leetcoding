class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
        
        for (String word: words2) {
            int[] tempFreq = new int[26];
            for (char c: word.toCharArray()) {
                tempFreq[c - 'a']++;
                freq[c- 'a'] = Math.max(freq[c- 'a'], tempFreq[c-'a']);
            }
        }

        List<String> res = new ArrayList<>();
        for (String word: words1) {
            int[] tempFreq = new int[26];
            for (char c: word.toCharArray()) {
                tempFreq[c - 'a']++;
            }

            boolean universal = true;
            for (int i = 0; i < 26; i++) {
                if (tempFreq[i] < freq[i]) {
                    universal = false;
                    break;
                }
            }    
            if (universal) res.add(word);
        }

        return res;
    }
}