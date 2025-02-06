class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        set.add(beginWord);
        if (!set.contains(endWord)) return 0;

        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        Set<String> visited = new HashSet();
        Queue<Pair<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });

        queue.add(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int number = pair.getValue();

            if (word.equals(endWord)) return number;
            if (visited.contains(word)) continue;
            visited.add(word);

            for (int i = 0; i < word.length(); i++) {
                for (char letter: letters) {
                    String possibleNext = word.substring(0, i) + letter + word.substring(i+1);
                    if (set.contains(possibleNext)) {
                        queue.add(new Pair(possibleNext, number + 1));
                    }
                }
            }
        }

        return 0;
    }
}