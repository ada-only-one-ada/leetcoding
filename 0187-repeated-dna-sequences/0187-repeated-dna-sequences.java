class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (right - left + 1 == 10) {
                String substring = s.substring(left, right + 1);
                if (set.contains(substring) && !res.contains(substring)) {
                    res.add(substring);
                }
                left++;
                set.add(substring);
            }
        }

        return res;
    }
}