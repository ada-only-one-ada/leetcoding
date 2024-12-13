/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode i1 = list1;
        ListNode i2 = list2;
        while (i1 != null && i2 != null) {
            if (i1.val <= i2.val) {
                curr.next = i1;
                i1 = i1.next;
            } else {
                curr.next = i2;
                i2 = i2.next;
            }
            curr = curr.next;
        }

        if (i1 != null) {
            curr.next = i1;
        }

        if (i2 != null) {
            curr.next = i2;
        }

        return dummy.next;
    }
}