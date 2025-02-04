class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node root = p;
        while (root.parent != null) {
            root = root.parent;
        }

        return helper(root, p, q);
    }

    public Node helper(Node root, Node p, Node q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        Node left = helper(root.left, p, q);
        Node right = helper(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}