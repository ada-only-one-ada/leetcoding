class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (ListNode head: lists){
            while (head != null){
                queue.add(head);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!queue.isEmpty()){
            curr.next = queue.poll();
            curr = curr.next;
        }

        curr.next = null;

        return dummy.next;
    }
}