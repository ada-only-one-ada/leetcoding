class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null; // head=[], k=0
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }        

        k %= size;
        if (k == 0) return head;
        int newHeadPos = size - k;
        
        ListNode prev = null;
        curr = head;
        int currIndex = 0;
        
        while (currIndex < newHeadPos) {
            currIndex++;
            prev = curr;
            curr = curr.next;
        }

        ListNode newHead = curr;
        prev.next = null;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        return newHead;
    }
}