class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            String key = "";
            for (int i = 0; i < 26; i++) {
                key += freq[i] + ",";
            }

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            } 
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> vals: map.values()) {
            res.add(vals);
        }
        
        return res;
    }
}