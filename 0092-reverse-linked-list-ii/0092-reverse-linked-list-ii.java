class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果没有需要反转的部分，直接返回原头结点
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 找到反转区间的前一个节点
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // reverseStart 指向需要反转的第一个节点
        ListNode reverseStart = prev.next;
        // reverseEnd 指向需要反转的最后一个节点
        ListNode reverseEnd = reverseStart;
        // 第一个节点算一个，需要找 right-left+1 个
        for (int i = 1; i < right - left + 1; i++) {
            reverseEnd = reverseEnd.next;
        }

        // 记录反转部分的后一个节点
        ListNode after = reverseEnd.next;
        // 断开反转部分与后面的链表
        reverseEnd.next = null;

        // 反转从start到end的部分
        prev.next = reverse(reverseStart);
        // 连接反转后的部分与after
        // 注意是从reverseStart连，比如例子里面的节点2，连接到5
        reverseStart.next = after;

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
        }

        return prev;
    }
}