class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks) {
            freq[task - 'A']++;
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return freq[b] - freq[a];
        });

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> wl = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                if (queue.isEmpty() && wl.size() == 0) break; // 最后有可能没了
                if (!queue.isEmpty()) {
                    int currTask = queue.poll();
                    sb.append((char)(currTask + 'A'));
                    freq[currTask]--;
                    if (freq[currTask] > 0) wl.add(currTask);
                } else {
                    sb.append("I");
                }
            }

            for (int t: wl) {
                queue.add(t);
            }
        }

        System.out.println(sb.toString());

        return sb.length();
    }
}