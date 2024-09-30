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

        // curr 指针遍历：
        Node curr = head;
        while (curr != null) {
            // 下一个遍历节点先存起来
            Node nextCurr = curr.next; 

            // 复制一个curr的新节点
            Node copyNode = new Node(curr.val);

            // curr -> copyNode -> nextCurr
            // 原始1 -> copy1 -> 原始2 -> copy2.....
            curr.next = copyNode;
            copyNode.next = nextCurr;
            curr = nextCurr;
        }

        // curr 指针遍历：
        curr = head;
        while (curr != null) {
            // 之前复制的新节点是它的下一个，即next
            Node copyNode = curr.next;

            // 如果当前原节点 random 不为 null
            if (curr.random != null) {
                // 那么复制的新节点的random，是原节点的random的复制，即原节点.random.next
                copyNode.random = curr.random.next;
            }

            // curr 跳到下一个非复制节点
            curr = curr.next.next;
        }

        // 创建一个新链表头，以便返回
        Node newHead = head.next;
        // 新链表头指针遍历
        Node newHeadCurr = newHead;

        // curr 指针遍历：
        curr = head;
        while (curr != null) {
            Node nextCurr = curr.next.next;
            // 拿到当前节点的复制节点
            Node copyNode = curr.next;

            // 拿到当前节点的原始 next 节点，它被连到了复制节点的下一个
            Node prevNext = copyNode.next; // 复原
            // 当前节点的原始 next 节点不为空

            // 复原原始节点和它的next的连接
            curr.next = prevNext;

            if (prevNext != null) {
                // 新头节点的next即是原始 next的复制
                newHeadCurr.next = prevNext.next;
                newHeadCurr = newHeadCurr.next;
            } else {
                newHeadCurr.next = null; // 避免最后一个节点要设置成null
            }

            // curr 跳到下一个非复制节点，使用原始链表的下一个节点继续
            // 在一开始保存的，或者使用curr = prevNext（已被复原）
            curr = nextCurr;
        }

        return newHead;
    }
}