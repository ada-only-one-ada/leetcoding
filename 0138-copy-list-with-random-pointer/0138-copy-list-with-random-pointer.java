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
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            Node nextHead = curr.next;

            Node copyNode = new Node(curr.val);
            curr.next = copyNode;
            copyNode.next = nextHead;
            
            curr = nextHead;
        }

        curr = head;
        while (curr != null) {
            Node copyCurr = curr.next;

            if (curr.random != null) {
                copyCurr.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newHead = head.next;
        Node newHeadCurr = newHead;

        curr = head;
        while (curr != null) {
            Node copyCurr = curr.next;
            Node prevNext = curr.next.next;

            curr.next = prevNext;
            if (prevNext != null) {
                copyCurr.next = prevNext.next;
            } else {
                copyCurr.next = null;
            }

            curr = prevNext;
        }

        return newHead;
    }
}