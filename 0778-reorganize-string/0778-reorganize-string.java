class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int max = 0;

        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
            max = Math.max(max, freq[c - 'a']);
        }

        if (s.length() - max < max - 1) return "";

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                queue.add((char)(i + 'a'));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            if (queue.size() == 1 && freq[queue.peek() - 'a'] > 1) {
                return "";
            }

            List<Character> wl = new ArrayList<>();
            for (int i = 0; i < 2 && !queue.isEmpty(); i++) {
                char c = queue.poll();
                res.append(c);
                freq[c - 'a']--;
                if (freq[c - 'a'] > 0) {
                    wl.add(c);
                }
            }

            for (char c: wl) {
                queue.add(c);
            }
        }

        return res.toString();
    }
}