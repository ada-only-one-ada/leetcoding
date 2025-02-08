class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // start from room 0

        return dfs(rooms, 0, new HashSet());
    }

    public boolean dfs(List<List<Integer>> rooms, int currRoom, Set<Integer> visited) {
        if (visited.size() == rooms.size() - 1) {
            return true;
        }
       
        visited.add(currRoom);
        for (int nextRoom: rooms.get(currRoom)) {
            if (!visited.contains(nextRoom) && dfs(rooms, nextRoom, visited)) {
                return true;
            }
        }

        return false;
    }
}