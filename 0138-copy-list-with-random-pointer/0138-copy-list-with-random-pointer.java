/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        for (Node oldNode: map.keySet()) {
            Node newNode = map.get(oldNode);

            Node oldRandom = oldNode.random;
            newNode.random = map.get(oldRandom);
            Node oldNext = oldNode.next;
            newNode.next = map.get(oldNext);
        }

        return map.get(head);
    }
}