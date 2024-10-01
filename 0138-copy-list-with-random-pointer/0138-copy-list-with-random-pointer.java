class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node origin = head;
        while (origin != null) {
            Node nextOrigin = origin.next;

            Node copy = new Node(origin.val);
            origin.next = copy;
            copy.next = nextOrigin;

            origin = nextOrigin;
        }

        origin = head;
        while (origin != null) {
            Node nextOrigin = origin.next.next;
           
            Node copy = origin.next;
            if (origin.random != null) {
                copy.random = origin.random.next;
            }

            origin = nextOrigin;
        }

        Node newHead = head.next;
        Node newCopy = newHead;

        origin = head;
        while (origin != null) {
            Node nextOrigin = origin.next.next;

            Node copy = origin.next;
            Node originNext = copy.next; 
            origin.next = originNext; // restore
            if (originNext != null) {
                newCopy.next = originNext.next;
                newCopy = newCopy.next;
            } else {
                newCopy.next = null; // the last node 
            }

            origin = nextOrigin;
        }

        return newHead;
    }
}