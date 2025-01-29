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
        // old - new
        Map<Node, Node> map = new HashMap<>();      
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }  

        for (Node oldNode: map.keySet()) {
            Node copyNode = map.get(oldNode);
            if (oldNode.next != null) {
                Node oldNext = oldNode.next;
                Node newNext = map.get(oldNext);
                copyNode.next = newNext;
            }

            if (oldNode.random != null) {
                Node oldRandom = oldNode.random;
                Node newRandom = map.get(oldRandom);
                copyNode.random = newRandom;
            }
        }

        return map.get(head);
    }
}