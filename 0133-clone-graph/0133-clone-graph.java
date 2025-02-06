class Solution {
    Map<Integer, Node> map = new HashMap<>(); // val: node
    Set<Integer> visited = new HashSet<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        cloneNode(node);
        cloneNei(node);
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

    public void cloneNei(Node node) {
        if (!visited.contains(node.val)) {
            visited.add(node.val);

            for (Node nei: node.neighbors) {
                map.get(node.val).neighbors.add(map.get(nei.val));
                cloneNei(nei);
            }
        }
    }
}