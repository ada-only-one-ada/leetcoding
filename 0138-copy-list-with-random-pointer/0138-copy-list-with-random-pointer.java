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
            Node nextCurr = curr.next;

            // curr -> copyNode -> nextCurr
            // 原始1 -> copy1 -> 原始2 -> copy2.....
            Node copyNode = new Node(curr.val);
            curr.next = copyNode;
            copyNode.next = nextCurr;
            curr = nextCurr;
        }

        curr = head;
        while (curr != null) {
            Node copyNode = curr.next;

            if (curr.random != null) {
                copyNode.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // 原始1 -> copy1 -> 原始2 -> copy2.....
        Node newHead = head.next;
        Node newHeadCurr = newHead; 

        curr = head;
        while (curr != null) {
            Node nextCurr = curr.next.next;

            Node copyNode = curr.next;
            Node originalNext = copyNode.next;
            
            curr.next = originalNext; // 复原
            if (originalNext != null) {
                newHeadCurr.next = originalNext.next;
                newHeadCurr = newHeadCurr.next;
            } else {
                copyNode.next = null;
            }

            curr = nextCurr;
        }

        return newHead;
    }
}