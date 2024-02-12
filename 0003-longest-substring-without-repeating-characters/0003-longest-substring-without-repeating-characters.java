class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];//s consists of English letters, digits, symbols and spaces.
        int res = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++){
            freq[s.charAt(right)]++;

            while (freq[s.charAt(right)] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            res = Math.max(res, right-left+1);
        }

        return res;
    }
}