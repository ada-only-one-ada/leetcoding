class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> freq[b] - freq[a]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                queue.add(i);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            // 剩下一种字母，且数量超过一个，直接返回
            if (queue.size() == 1 && freq[queue.peek()] > 1) {
                return "";
            }

            if (queue.size() == 1) {
                res.append((char)(queue.poll() + 'a'));
                break;
            } else if (queue.size() >= 2) {
                int i1 = queue.poll();
                int i2 = queue.poll();

                res.append((char)(i1 + 'a'));
                res.append((char)(i2 + 'a'));

                freq[i1]--;
                freq[i2]--;
                if (freq[i1] > 0) queue.add(i1);
                if (freq[i2] > 0) queue.add(i2);
            }
        }

        return res.toString();
    }
}