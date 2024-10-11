class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char o = order.charAt(i);
            if (freq[o - 'a'] > 0) {
                for (int j = 0; j < freq[o - 'a']; j++) {
                    res.append(o);
                }
                freq[o - 'a'] = 0;
            }
        }

        // 有些字符可能在 order 没有出现
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                for (int j = 0; j < freq[i]; j++) {
                    res.append((char) (i + 'a'));
                }
            }
        }

        return res.toString();
    }
}