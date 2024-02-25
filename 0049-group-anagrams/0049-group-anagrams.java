class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] freq = new int[26];

        for (String str: strs) {                //O(n):n个string
            Arrays.fill(freq, 0);
            for (char c: str.toCharArray()) {         //O(k):each string takes k个时间统计freq（k是str的len）
                freq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {            //O(|Σ|) = (O(26)：遍历26个字母生成key
                sb.append(freq[i]);
                sb.append("#");
             
                //["bdddddddddd","bbbbbbbbbbc"], b1d10 and b10c1
                // has #: 1#0#10 and 10#1#0
                // no #: 1010 and 1010 -> wrong

            }
            String curr = sb.toString();

            if (!map.containsKey(curr)) {             //O(1)：更新哈希表
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}