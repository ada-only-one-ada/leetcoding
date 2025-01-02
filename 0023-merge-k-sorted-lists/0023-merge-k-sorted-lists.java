class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }
    
    private ListNode divide(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];
        
        int mid = start + (end - start) / 2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);
        
        return mergeTwoLists(left, right);
    }
    
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 
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