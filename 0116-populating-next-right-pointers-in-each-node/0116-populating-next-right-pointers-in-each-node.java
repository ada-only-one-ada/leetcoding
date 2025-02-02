class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prevNode = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (prevNode != null) prevNode.next = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                prevNode = node;
            }
            prevNode.next = null;
        }

        return root;
    }
}