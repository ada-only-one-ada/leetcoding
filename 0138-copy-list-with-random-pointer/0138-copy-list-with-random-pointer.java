class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        if (!map.containsKey(head)) {
            Node copyHead = new Node(head.val);
            map.put(head, copyHead); // 注意顺序，这里要先把copyHead放入map，再进行递归

            copyHead.next = copyRandomList(head.next);
            copyHead.random = copyRandomList(head.random);
 
            return copyHead; // 注意返回
        } else {
            return map.get(head);
        }
    }
}