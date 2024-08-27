class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c: word.toCharArray()) {
            freq[c - 'a']++;
        }

        Queue<Character> queue = new PriorityQueue<>((a, b) -> {
            return freq[b - 'a'] - freq[a - 'a'];
        });

        for (int i = 0; i < freq.length; i++) {
            queue.add((char) (i + 'a'));
        }

        int res = 0;

        int[] cost = new int[8];
        Arrays.fill(cost, 1);
        while (!queue.isEmpty()) {
            for (int i = 0; !queue.isEmpty() && i < cost.length; i++) {
                res += cost[i] * freq[queue.poll() - 'a'];
                cost[i]++;
            }
        }

        return res;
    }
}