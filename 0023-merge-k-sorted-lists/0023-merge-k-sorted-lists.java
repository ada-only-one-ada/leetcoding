class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 如果输入的链表数组为空，则直接返回null
        if (lists.length == 0) return null;
        List<ListNode> res = new ArrayList<>(Arrays.asList(lists));
        
        // 当列表中还有多于一个链表时，继续合并
        while (res.size() > 1) {
            List<ListNode> temp = new ArrayList<>();
            // 每次循环合并两个链表，并将合并后的链表存入临时列表中
            for (int i = 0; i < res.size() - 1; i += 2) {
                temp.add(mergeTwoLists(res.get(i), res.get(i + 1)));
            }
            
            // 如果原始列表中的链表数量为奇数，则将最后一个链表直接加入到临时列表中
            if (res.size() % 2 == 1) {
                temp.add(res.get(res.size() - 1));
            }
            
            // 更新列表为新合并后的链表列表
            res = temp;
        }
        
        // 返回合并后的链表，此时res只包含一个链表，即最终合并结果
        return res.get(0);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 
        ListNode dummy = new ListNode(-1); // 创建一个虚拟头结点
        ListNode curr = dummy; // 使用当前节点指针来构建新链表

        // 遍历两个链表，每次取出较小的节点，添加到新链表中
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next; // 移动当前指针
        }

        // 如果其中一个链表已经为空，直接连接另一个链表的剩余部分
        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;

        return dummy.next; // 返回合并后的链表，跳过虚拟头结点
    }
}
