class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
    
        for (String word: words) {
            if (word.length() > chars.length()) continue;

            int[] freq = new int[26];
            for (char c: chars.toCharArray()) freq[c - 'a']++;
            for (char w: word.toCharArray()) freq[w - 'a']--;
            
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) res += word.length();
        }

        return res;
    }
}