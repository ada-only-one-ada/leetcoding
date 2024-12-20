class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Node prePointer = null;
        Node nextLevelHead = null;
        Node curr = root;

        while (curr != null){
            while (curr != null){
                if (curr.left != null){
                    if (nextLevelHead == null){
                        nextLevelHead = curr.left;
                        prePointer = curr.left;
                    }else if (nextLevelHead != null){
                        prePointer.next = curr.left;
                        prePointer = prePointer.next;
                    }
                }

                if (curr.right != null){
                    if (nextLevelHead == null){
                        nextLevelHead = curr.right;
                        prePointer = curr.right;
                    }else if (nextLevelHead != null){
                        prePointer.next = curr.right;
                        prePointer = prePointer.next;
                    }
                }
                curr = curr.next;
            }
            curr = nextLevelHead;
            prePointer = null;
            nextLevelHead = null;
        }
        return root;
    }
}