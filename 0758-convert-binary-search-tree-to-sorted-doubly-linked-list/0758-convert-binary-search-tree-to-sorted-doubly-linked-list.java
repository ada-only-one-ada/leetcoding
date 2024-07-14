class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        Stack<Node> stack = new Stack();
        Node head = null;
        Node prev = head;

        Node curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            Node node = stack.pop();
            if (prev != null) {
                node.left = prev;
                prev.right = node;
            } else {
                head = node;
            }
            prev = node;

            curr = node.right;
        }

        head.left = prev;
        prev.right = head;
        return head;
    }
}