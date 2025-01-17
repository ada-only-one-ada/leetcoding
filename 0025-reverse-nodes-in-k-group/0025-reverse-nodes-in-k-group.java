class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = dummy;

        while (prev != null) {
            for (int count = 0; count < k && end != null; count++) {
                end = end.next; // end = 2
            }
            
            if (end == null) break;

            ListNode nextHead = end.next; // nextHead = 3,4,5
            end.next = null; // 1,2,null

            ListNode start = prev.next; // (start)1,2
            prev.next = reverse(start); // dummy,2,1(start)
            start.next = nextHead;
            
            prev = start;
            end = start;
        }
        
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