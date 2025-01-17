class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        int count = 0;
        // 遍历链表
        ListNode curr = head;
        while (curr != null) {
            // 把下一次遍历的头节点先保存下来
            ListNode nextCurr = curr.next;
            count++;

            if (count == k) {
                // 跟下一段断开
                curr.next = null;
                ListNode reverseCurrGroup = reverse(head);

                // 把之前的段跟反转之后的相连
                prev.next = reverseCurrGroup;

                ListNode lastNode = reverseCurrGroup;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }

                // 把反转之后的跟下一段开头相连
                lastNode.next = nextCurr;

                // 更新 prev 节点
                prev = lastNode;
                
                // 更新下一段的头节点
                head = nextCurr;
                count = 0;
            }

            curr = nextCurr;
        }

        return dummy.next;
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