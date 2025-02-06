class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int id = pair.getValue();
                min = Math.min(id, min);
                max = Math.max(id, max);

                map.putIfAbsent(id, new ArrayList<>());
                map.get(id).add(node.val);

                if (node.left != null) {
                    queue.add(new Pair(node.left, id - 1));
                }

                if (node.right != null) {
                    queue.add(new Pair(node.right, id + 1));
                }
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}