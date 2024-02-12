class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>((p, q) -> q.getValue() - p.getValue());
        if (a != 0) queue.add(new Pair('a', a));
        if (b != 0) queue.add(new Pair('b', b));
        if (c != 0) queue.add(new Pair('c', c));

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            // 拿到第一个字母
            Pair<Character, Integer> first = queue.poll();
            char task = first.getKey();
            int freq = first.getValue();

            // 如果res的长度小于2，肯定不会有重合，随便贴
            if (res.length() <= 1) {
                res.append(task);
                if (freq - 1 > 0) queue.add(new Pair<>(task, freq - 1));
            // 如果res的长度大于等于2，分情况
            } else if (res.length() >= 2) {
                // 如果说当前task跟倒数前两个有其中一个是不一样的，那么也肯定不会有重合，随便贴
                int sbLen = res.length();
                if (task != res.charAt(sbLen - 1) || task != res.charAt(sbLen - 2)) {
                    res.append(task);
                    if (freq - 1 > 0) queue.add(new Pair<>(task, freq - 1));
                // 否则，比如，cc，我们现在又遇到了c，我们要用一个不同的字母贴
                } else {
                    // 如果已经没有不同的字母了，那么不可以再贴了，直接返回当前的结果
                    if (queue.isEmpty()) return res.toString();

                    // 拿到第二个字母，也是随便贴的情况
                    Pair<Character, Integer> second = queue.poll();
                    char task2 = second.getKey();
                    int freq2 = second.getValue();

                    res.append(task2);
                    if (freq2 - 1 > 0) queue.add(new Pair<>(task2, freq2 - 1));
                    
                    // 因为第一个字母不能用，没用上，但我们之前取出来了，现在放回去下一轮用
                    queue.add(first);
                }
            }
        }
        
        return res.toString();
    }
}