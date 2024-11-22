class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // 快指针走 n+1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null ){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;     
    }
}