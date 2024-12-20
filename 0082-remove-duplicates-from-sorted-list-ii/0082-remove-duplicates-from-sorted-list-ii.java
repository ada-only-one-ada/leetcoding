class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(-1000);  // 创建一个哑节点作为链表的新头部
        dummy.next = head;
        
        ListNode prevNode = dummy;   // prevNode 是指向最后一个无重复节点的指针
        ListNode currNode = head;    // currNode 是当前遍历到的节点
        
        while (currNode != null) {
            // 判断当前节点是否有重复节点
            boolean hasDuplicate = false;
            while (currNode.next != null && currNode.val == currNode.next.val) {
                hasDuplicate = true;
                currNode = currNode.next; // 继续前进到重复序列的最后一个节点
            }

            if (hasDuplicate) {
                // 如果存在重复，更新 prevNode.next 跳过所有重复节点
                prevNode.next = currNode.next;
            } else {
                // 如果不存在重复，移动 prevNode 到 currNode
                prevNode = currNode;
            }

            // 移动 currNode 到下一个节点
            currNode = currNode.next;
        }
        
        return dummy.next; // 返回哑节点的下一个节点，即更新后的链表头部
    }
}
