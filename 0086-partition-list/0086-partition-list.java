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
        ListNode lessList = new ListNode(-1);
        ListNode less = lessList;

        ListNode moreList = new ListNode(-1);
        ListNode more = moreList;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                more.next = curr;
                more = more.next;
            }

            curr = curr.next;
        }

        less.next = moreList.next;
        more.next = null; // 要断开
        return lessList.next;
    }
}