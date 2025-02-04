class Solution {
    public boolean isPalindrome(ListNode head) {
        // O(n) time and O(1) space
        ListNode middleNode = findMiddleNode(head);
        ListNode secondHalf = reverse(middleNode.next);
        middleNode.next = null;

        ListNode l1 = head;
        ListNode l2 = secondHalf;
        while (l1 != null &&  l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        // 复原
        middleNode.next = reverse(secondHalf);
        return true;
    }

    public ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
        }
        return prev;
    }
}