class FileSharing {
    Map<Integer, Set<Integer>> map; // chunkId: <user1, user2>
    PriorityQueue<Integer> queue; // previous available id
    int id; // new id
    Map<Integer, List<Integer>> userToChunks;

    public FileSharing(int m) {
        map = new HashMap<>(); 
        queue = new PriorityQueue<>();
        id = 1;
        userToChunks = new HashMap<>();
    }
    
    public int join(List<Integer> ownedChunks) {
        int assignedId;

        if (!queue.isEmpty()) {
            assignedId = queue.poll();
        } else {
            assignedId = this.id++;
        }

        for (int chunk: ownedChunks) {
            map.putIfAbsent(chunk, new HashSet<>());
            map.get(chunk).add(assignedId);
        }

        userToChunks.put(assignedId, ownedChunks);
        return assignedId;
    }
    
    public void leave(int userID) {
        for (int chunk: userToChunks.get(userID)) {
            map.get(chunk).remove(userID);
        }
        queue.add(userID);
    }
    
    public List<Integer> request(int userID, int chunkID) {
        if (!map.containsKey(chunkID) || map.get(chunkID).size() == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>(map.get(chunkID));  
        Collections.sort(res);
        map.get(chunkID).add(userID);
        userToChunks.get(userID).add(chunkID);
        
        return res;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */