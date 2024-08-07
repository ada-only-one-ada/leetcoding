public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
       
        Set<ListNode> visited = new HashSet<>();
        
        while (head != null){
            if (visited.contains(head)){
                return true;
            }else{
                visited.add(head);
                head = head.next;
            }
        }
        
        return false;
    }
}