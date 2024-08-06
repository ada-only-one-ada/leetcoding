class Solution {
    public int lengthOfLongestSubstring(String s) {
        // s consists of English letters, digits, symbols and spaces.
        int[] freq = new int[128];
        int res = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++){
            while (freq[s.charAt(right)] == 1){
                freq[s.charAt(left)]--;
                left++;
            }

            freq[s.charAt(right)]++;

            res = Math.max(res, right-left+1);
        }

        return res;
    }
}