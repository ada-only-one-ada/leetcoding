class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : s.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        
        StringBuilder res = new StringBuilder();
        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (char letter : map.keySet()) {
            queue.add(new Pair(letter, map.get(letter)));
        }
        
        Queue<Pair<Character, Integer>> wl = new LinkedList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i <= 1; i++) {
                if (queue.isEmpty() && wl.isEmpty()) break;
                
                if (!queue.isEmpty()) {
                    Pair<Character, Integer> curr = queue.poll();
                    char task = curr.getKey();
                    int freq = curr.getValue();
                    
                    if (res.length() > 0 && task == res.charAt(res.length() - 1)) return "";
                    res.append(task);
                    
                    if (freq - 1 > 0) {
                        wl.add(new Pair(task, freq - 1));
                    }
                } 
            }
            
            while (!wl.isEmpty()) {
                queue.add(wl.poll());
            }
        }
        
        return res.toString();        
    }
}