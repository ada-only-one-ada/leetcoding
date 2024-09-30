class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        if (!map.containsKey(head)) { // 如果 map 中不包含当前节点，表示该节点尚未被复制
            Node copyHead = new Node(head.val);
            // 将原节点 head 和其复制节点 copyHead 之间的关系存入 map
            map.put(head, copyHead); // 注意顺序，这里要先把copyHead放入map，再进行递归

            // 递归处理 next 和 random 指针
            copyHead.next = copyRandomList(head.next);
            copyHead.random = copyRandomList(head.random);
 
            return copyHead; // 返回复制的节点
        } else {
            // 如果当前节点已经被复制过，则直接从 map 中获取并返回对应的复制节点
            return map.get(head);
        }
    }
}