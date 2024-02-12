class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks) {
            freq[task - 'A']++;
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int count: freq) {
            if (count != 0) {
                queue.add(count);
            }
        }
        
        int timeUsed = 0;
        while (!queue.isEmpty()) {
            List<Integer> wl = new ArrayList<>();
            
            // Try to schedule up to n + 1 tasks within one interval
            for (int i = 0; i <= n; i++) {
                // 这里如果到了最后一个task，那么做完以后，即使这个loop还没有结束，因为wl是空的，queue也是空的，直接退出就好了
                // Break if no more tasks
                if (queue.isEmpty() && wl.isEmpty()) break;
                
                if (!queue.isEmpty()) {
                    int task = queue.poll();   
                    // Add to waiting list if still remaining
                    if (task - 1 > 0) {
                        wl.add(task - 1);
                    }
                } 
                timeUsed++;
            }
            
            // Add waiting tasks back to queue
            for (int task: wl) {
                queue.add(task);
            }
        }

        return timeUsed;
    }
}