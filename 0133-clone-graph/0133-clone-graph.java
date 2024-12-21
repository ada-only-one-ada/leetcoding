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
        Map<Node, Node> map = new HashMap<>();
        queue.add(node);
         map.put(node, new Node(node.val, new ArrayList<>())); // 创建新curr

        
        while (!queue.isEmpty()) {
           
                Node curr = queue.poll();
               
                List<Node> neis = curr.neighbors;
                if (neis == null) continue;
                for (Node nei: neis) {
                    if (!map.containsKey(nei)) {
                        queue.add(nei);
                        map.put(nei, new Node(nei.val, new ArrayList<>())); // 创建curr的nei的新nei
                    }

                    map.get(curr).neighbors.add(map.get(nei));
                }
            
        }

        return map.get(node);
    }
}