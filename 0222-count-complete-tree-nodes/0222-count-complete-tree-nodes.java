class Solution {
    static Map<TreeNode, Integer> map = new HashMap();
    public static int countNodes(TreeNode node) {
        int res = helper(node);

        for (TreeNode curr: map.keySet()) {
            System.out.println("Node " + curr.val + " has size of " + map.get(curr));
        } 
        return res;
    }
    
    public static int helper(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        
        int totalSize = 1 + helper(node.left) + helper(node.right);
        
        map.put(node, totalSize);
        return totalSize;
    }
}
       