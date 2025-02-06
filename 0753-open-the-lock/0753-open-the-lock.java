class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> ends = new HashSet<>();
        for (String deadend: deadends) {
            ends.add(deadend);
        }

        Queue<Pair<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });
        queue.add(new Pair("0000", 0));

        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String password = pair.getKey();
            int turns = pair.getValue();

            if (password.equals(target)) return turns;

            if (ends.contains(password) || visited.contains(password)) continue;
            visited.add(password);

            for (int i = 0; i < 4; i++) {
                char c = password.charAt(i);
                int cVal = Character.getNumericValue(c);
                int minusOne = (cVal - 1 + 10) % 10;
                int plusOne = (cVal + 1) % 10;

                String p1 = password.substring(0, i) + String.valueOf(minusOne) + password.substring(i + 1);
                String p2 = password.substring(0, i) + String.valueOf(plusOne) + password.substring(i + 1);

                queue.add(new Pair(p1, turns + 1));
                queue.add(new Pair(p2, turns + 1));
            }
        }

        return -1;
    }
}