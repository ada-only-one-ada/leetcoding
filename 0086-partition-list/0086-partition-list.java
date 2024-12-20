class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode lessList = new ListNode(-1);
        ListNode moreList = new ListNode(-1);
        ListNode less = lessList;
        ListNode more = moreList;
        
        ListNode curr = head;
        while (curr != null){
            ListNode copy = new ListNode(curr.val);
            if (copy.val < x){
                less.next = copy;
                less = less.next;
            }else if (copy.val >= x){
                more.next = copy;
                more = more.next;
            }
            curr = curr.next;
        }

        less.next = moreList.next;
        return lessList.next;
    }
}