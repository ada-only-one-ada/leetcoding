class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String seq1 = formSequence(root1, new StringBuilder());
        String seq2 = formSequence(root2, new StringBuilder());
        return seq1.equals(seq2);
    }

    public String formSequence(TreeNode root, StringBuilder sequence) {
        if (root == null) return "";
        
        if (root.left == null && root.right == null) {
            sequence.append(root.val).append(",");
        }

        formSequence(root.left, sequence);
        formSequence(root.right, sequence);

        return sequence.toString();
    }
}