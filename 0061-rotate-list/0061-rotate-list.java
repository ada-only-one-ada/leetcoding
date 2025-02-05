class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;

        int len = getLen(head);
        if(len == 0) return head;
        k = k % len;
        if (k == len || k == 0 || head == null || head.next == null) return head;

        head = reverse(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }

        ListNode secondHalf = reverse(curr.next);
        curr.next = null;
        ListNode firstHalf = reverse(head);
        ListNode p = firstHalf;
        while (p.next != null) {
            p = p.next;
        }
        p.next = secondHalf;
        return firstHalf;
    }

    public int getLen(ListNode head) {
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
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