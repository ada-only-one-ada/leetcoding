class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int removedPos = size - n;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        curr = dummy;
        int currPos = -1;
        
        while (currPos != removedPos - 1) {
            curr = curr.next;
            currPos++;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }
}