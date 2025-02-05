class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();

        copyNode(node, map);
        copyNeis(node, map, new HashSet<>());
        return map.get(node.val);
    }

    public void copyNode(Node node, Map<Integer, Node> map) {
        if (!map.containsKey(node.val)) {
            map.put(node.val, new Node(node.val, new ArrayList<>()));

            for (Node oldNei: node.neighbors) {
                copyNode(oldNei, map);
            }
        }
    }

    public void copyNeis(Node node, Map<Integer, Node> map, Set<Integer> visited) {
        if (!visited.contains(node.val)) {
            visited.add(node.val);

            for (Node oldNei: node.neighbors) {
                map.get(node.val).neighbors.add(map.get(oldNei.val));

                copyNeis(oldNei, map, visited);
            }
        }
    }
}