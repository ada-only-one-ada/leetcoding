class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0 ) + 1);
        }
        
        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (char task : map.keySet()) {
            queue.add(new Pair(task, map.get(task)));
        }
        
        int timeUsed = 0;
        Queue<Pair<Character, Integer>> wl = new LinkedList<>();
        int idle = 0;
        
        while (!queue.isEmpty()) {
            idle = 0;
            for (int i = 0; i <= n; i++) { 
                timeUsed++;
                if (!queue.isEmpty()) {
                    Pair<Character, Integer> curr = queue.poll();
                    char task = curr.getKey();
                    int freq = curr.getValue();
                    
                    if (freq - 1 > 0) {
                        wl.add(new Pair(task, freq - 1));
                    }
                } else {
                    idle++;
                }
            }
            
            while (!wl.isEmpty()) {
                queue.add(wl.poll());
            }
        }
        
        return timeUsed - idle;
    }
}