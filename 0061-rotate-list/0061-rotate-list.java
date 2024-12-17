class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        k %= size;
        if (k == 0) return head;

        int newHeadPos = size - k; // zeroIndex
        ListNode newHead = head;
        ListNode prev = null;

        for (int i = 0; i < newHeadPos; i++) {
            prev = newHead;
            newHead = newHead.next;
        }

        prev.next = null;
        curr = newHead;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }

        if (curr != null) curr.next = head;
        return newHead;
    }
}