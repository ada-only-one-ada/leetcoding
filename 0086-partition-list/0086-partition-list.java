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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode lessCurr = less;

        ListNode equalMore = new ListNode(-1);
        ListNode equalMoreCurr = equalMore;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                lessCurr.next = curr;
                lessCurr = lessCurr.next;
            } else {
                equalMoreCurr.next = curr;
                equalMoreCurr = equalMoreCurr.next;
            }

            curr = curr.next;
        }

        lessCurr.next = equalMore.next;
        equalMoreCurr.next = null;
        return less.next;
    }
}