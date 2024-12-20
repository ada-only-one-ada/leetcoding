class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);  // 创建一个哑节点作为链表的新头部
        dummy.next = head;
        
        ListNode prev = dummy;  // prev 起始位于哑节点，表示上一个添加到结果链表中的节点
        ListNode curr = head;   // curr 为当前正在遍历的节点

        while (curr != null) {
            // 检查当前节点是否是唯一的
            if ((curr.next == null || curr.next.val != curr.val) && (prev.next == curr)) {
                // 如果 curr 是唯一的，并且紧跟在 prev 后面，直接将 prev 前移至 curr
                prev = curr;
            } else {
                // 如果 curr 不是唯一的，找到下一个唯一的节点
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;  // 跳过所有重复的节点
                }
                // 更新 prev.next 指向 curr 的下一个节点（第一个不重复的节点）
                prev.next = curr.next;
            }
            // 移动 curr 到下一个节点
            curr = curr.next;
        }
        
        return dummy.next; // 返回哑节点的下一个节点，即更新后的链表头部
    }
}
