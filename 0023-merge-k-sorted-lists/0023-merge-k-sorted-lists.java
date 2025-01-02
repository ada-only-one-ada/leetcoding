class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (ListNode head: lists){
            while (head != null){
                queue.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!queue.isEmpty()){
            curr.next = new ListNode(queue.poll());
            curr = curr.next;
        }

        return dummy.next;
    }
}