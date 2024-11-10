class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < word1.length || j < word2.length) {
            if (i < word1.length) {
                sb1.append(word1[i]);
                i++;
            }

            if (j < word2.length) {
                sb2.append(word2[j]);
                j++;
            }
        }

        return sb1.toString().equals(sb2.toString());
    }
}