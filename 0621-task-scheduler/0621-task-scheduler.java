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
            
            // if there is idel time, we also need to finish the current loop which contains n times
            for (int i = 0; i <= n; i++) {
                // has task
                if (!queue.isEmpty()) {
                    int task = queue.poll();
                    timeUsed++;
                    
                    if (task - 1 > 0) {
                        wl.add(task - 1);
                    }
                // idle until the next loop if we still have next round
                // otherwise queue & wl is empty, we don't need to idle the last task
                } else if (queue.isEmpty() && !wl.isEmpty()) {
                    timeUsed += n - i + 1;
                    break;
                }    
            }
            
            // after n times... 
            // we can also declare wl outside the loop as queue, and poll to empty it at each loop
            for (int task: wl) {
                queue.add(task);
            }
        }

        return timeUsed;
    }
}