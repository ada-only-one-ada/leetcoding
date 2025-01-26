class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                /*
                TreeNode leftMax = root.left;
                while (leftMax.right != null) {
                    leftMax = leftMax.right;
                }

                leftMax.right = root.right;
                return root.left;
                */

                TreeNode rightMin = root.right;
                while (rightMin.left != null) {
                    rightMin = rightMin.left;
                }

                rightMin.left = root.left;
                return root.right;
            }
        }

        return root;
    }
}