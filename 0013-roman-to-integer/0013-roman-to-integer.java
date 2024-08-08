class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            int prev = map.get(s.charAt(i - 1));
            int curr = map.get(s.charAt(i));

            if (prev >= curr) {
                res += prev;
            } else {
                res -= prev;
            }
        }

        res += map.get(s.charAt(s.length() - 1));
        return res;
    }
}