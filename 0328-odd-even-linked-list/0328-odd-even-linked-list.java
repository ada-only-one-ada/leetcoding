class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode odd = oddDummy;

        ListNode evenDummy = new ListNode(-1);
        ListNode even = evenDummy;
        int index = 0;

        while (head != null) {
            if (index % 2 == 1) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            index++;
        }

        even.next = null;
        odd.next = evenDummy.next;        
        return oddDummy.next;
    }
}