class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 创建一个虚拟头节点，以便简化对头节点操作的复杂性
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        // 移动指针，找到反转区间的前一个节点
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        // leftPart指向反转区间前的最后一个节点
        ListNode leftPart = prev;

        // 开始反转从left到right的节点
        prev = null;
        for (int i = left; i <= right; i++) {
            ListNode nextHead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextHead;
        }

        // 将反转后的部分连接回原链表
        // leftPart.next指向反转后的第一个节点（原来的right位置的节点）
        leftPart.next.next = curr; // 将反转部分的最后一个节点（原left位置的节点）连接到right后面的节点
        leftPart.next = prev; // 将反转部分的开始连接到原链表中left之前的部分
        return dummy.next; // 返回新的头节点
    }
}
