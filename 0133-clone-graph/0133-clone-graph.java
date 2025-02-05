class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, new Node(node.val, new ArrayList<>()));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            for (Node oldNei: oldNode.neighbors) {
                if (!map.containsKey(oldNei.val)) {
                    map.put(oldNei.val, new Node(oldNei.val, new ArrayList<>()));
                    queue.add(oldNei);
                }

                map.get(oldNode.val).neighbors.add(map.get(oldNei.val));
            }
        }

        return map.get(node.val);
    }
}