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
        if (head == null) return head;
        
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val, null, null));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.next != null) { // 这里也可以不用判断，因为是null的话，map.get(null) 或者map.get(不存在）会返回null
                map.get(curr).next = map.get(curr.next);
            }

            if (curr.random != null) {
                map.get(curr).random = map.get(curr.random);
            }
            
            curr = curr.next;
        }

        return map.get(head);
    }
}