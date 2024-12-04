class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Queue<Pair<Character, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            queue.add(new Pair((char)(i+'a') , freq[i]));
        }
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            if (queue.size() == 1 && queue.peek().getValue() > 1) return "";
            List<Pair<Character, Integer>> wl = new ArrayList<>();

            for (int i = 0; i < 2 && !queue.isEmpty(); i++) {
                Pair<Character, Integer> curr = queue.poll();
                char currChar = curr.getKey();
                sb.append(currChar);

                int currFreq = curr.getValue();
                if (currFreq - 1 > 0) {
                    wl.add(new Pair(currChar, currFreq - 1));
                } 
            }

            for (Pair<Character, Integer> pair: wl) {
                queue.add(pair);
            }
        }

        return sb.toString();
    }
}