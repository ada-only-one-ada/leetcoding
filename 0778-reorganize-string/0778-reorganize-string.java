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
            // 只剩下一种字母了，且这个字母的个数超过一个：aaa
            if (queue.size() == 1 && freq[queue.peek()] > 1) {
                return "";
            }

            // 加2个字母，就可以重复加第一个，比如：ab 接着又可以加 a 了
            List<Integer> waitingList = new ArrayList<>();
            for (int i = 1; i <= 2; i++) {
                if (waitingList.isEmpty() && queue.isEmpty()) break;
                if (!queue.isEmpty()) {
                    int index = queue.poll();
                    res.append((char)(index + 'a'));
                    freq[index] -= 1;

                    if (freq[index] > 0) {
                        waitingList.add(index);
                    }
                }
            }
            
            for (int index: waitingList) {
                queue.add(index);
            }
        }

        return res.toString();
    }
}