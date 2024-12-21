/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Map<Node, Node> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                map.put(curr, new Node(curr.val, new ArrayList<>()));

                List<Node> neis = curr.neighbors;
                if (neis == null) continue;
                for (Node nei: neis) {
                    if (!map.containsKey(nei)) {
                        queue.add(nei);
                    }
                }
            }
        }

        for (Node oldNode: map.keySet()) {
            List<Node> oldNeis = oldNode.neighbors;
            if (oldNeis == null) continue;

            Node newNode = map.get(oldNode);
            for (Node oldNei: oldNeis) {
                newNode.neighbors.add(map.get(oldNei));
            }
        }

        return map.get(node);
    }
}