class Solution {
    Map<Integer, Node> map;
    Set<Integer> visited;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        map = new HashMap<>();

        cloneNode(node);
        visited = new HashSet<>();
        cloneNeighbors(node);

        return map.get(node.val);
    }

    public void cloneNode(Node node) {
        if (!map.containsKey(node.val)) {
            map.put(node.val, new Node(node.val, new ArrayList<>()));

            for (Node nei: node.neighbors) {
                cloneNode(nei);
            }
        }
    }

    public void cloneNeighbors(Node node) {
        if (node == null || node.neighbors == null || node.neighbors.size() == 0) return;

        if (!visited.contains(node.val)) {
            visited.add(node.val);    

            for (Node oldNei: node.neighbors) {
                map.get(node.val).neighbors.add(map.get(oldNei.val));
                cloneNeighbors(oldNei);
            }
        }
    }
}