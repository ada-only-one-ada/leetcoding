import java.util.*;

class Solution {
    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> rank = new HashMap<>();
    
    public int removeStones(int[][] stones) {
        int id = 0; // unique identifier for each row and column
        Map<Integer, Integer> map = new HashMap<>(); // maps original index to unique id

        // Assign unique ids
        for (int[] stone : stones) {
            if (!map.containsKey(stone[0])) {
                map.put(stone[0], id++);
            }
            if (!map.containsKey(~stone[1])) { // Using ~stone[1] to differentiate columns from rows
                map.put(~stone[1], id++);
            }
        }

        // Perform union on each stone's row and column
        for (int[] stone : stones) {
            connect(map.get(stone[0]), map.get(~stone[1]));
        }

        // Find how many unique components there are
        Set<Integer> uniqueParents = new HashSet<>();
        for (Integer key : map.keySet()) {
            uniqueParents.add(find(map.get(key)));
        }

        // The number of stones minus the number of unique components
        return stones.length - uniqueParents.size();
    }

    private int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            rank.put(x, 1);
        }
        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x))); // Path compression
        }
        return parent.get(x);
    }

    private void connect(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank
            if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }
        }
    }
}
