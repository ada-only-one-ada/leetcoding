class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        // 
        int[] store = new int[26];
        int maximum = 0;

        for (int i = 0; i < n; i++) {
            store[s.charAt(i) - 'a']++;

            if (maximum < store[i]) {
                maximum = store[i];
            }
        }

        // aaabb, ababa, len 

        if (s.length() - maximum < maximum - 1) {
            return "";
        }
        // max: 至少要有max-1把他隔开
        // index
        // res: acabab work

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                return store[b] - store[a];
            }
        );

        // aaaa c d
        // a:3, d:1
        // res = ac a 


        for (int i = 0; i < 26; i++) {
            if (store[i] != 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();

            sb.append((char)(first + 'a'));
            sb.append((char)(second + 'a'));

            store[first]--;
            store[second]--;

            if (store[first] > 0) {
                pq.add(first);
            }

            if (store[second] > 0) {
                pq.add(second);
            }
        }
        // "aaabbcc"
        // a:0, b:0, c:0
        // "abacabc"
        
        if (pq.size() == 1) {
            sb.append((char)(pq.peek() + 'a'));
        }

        return sb.toString();
    }
        
}