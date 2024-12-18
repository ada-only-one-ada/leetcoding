class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 如果链表为空，直接返回
        if (head == null) return null; 

        // 遍历一边得到节点的数量
        int size = 0;
        ListNode currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }        

        // 简化 k 
        k %= size;
        // 如果 rotate 次数为0，直接返回
        if (k == 0) return head;

        // 计算出新的头节点的位置（index 从0开始）
        int newHeadPos = size - k;
        // 把新的头节点的前一个节点存起来，方便后续断开
        ListNode prevNode = null;

        // 重置开始遍历
        currNode = head;
        int currPos = 0;
        // 直到找到新的头节点的位置
        while (currPos < newHeadPos) {
            currPos++;
            prevNode = currNode;
            currNode = currNode.next;
        }

        // 新的头节点
        ListNode newHead = currNode;
        // 断开前一段
        prevNode.next = null;

        // 遍历到新的头节点那一段的最后一个节点
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        // 把最后一个节点连到旧的头节点
        currNode.next = head;
        // 返回新的头节点
        return newHead;
    }
}