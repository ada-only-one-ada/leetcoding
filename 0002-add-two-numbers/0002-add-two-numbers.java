class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int prev = 0;

        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;

            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = num1 + num2 + prev;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            prev = sum / 10;
        }

        if (prev > 0) {
            curr.next = new ListNode(prev);
        }
        return dummy.next;
    }
}