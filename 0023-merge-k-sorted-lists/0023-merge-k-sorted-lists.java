class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode head: lists) {
            res = mergeTwoList(res, head);
        }
        
        return res;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) { 
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;
        return dummy.next;
    }
}