class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char c: ransomNote.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c: magazine.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int f: freq) {
            if (f > 0) return false;
        }

        return true;
    }
}