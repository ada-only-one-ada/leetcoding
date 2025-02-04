class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        // col: <value, level>
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                max = Math.max(max, index);
                min = Math.min(min, index);

                map.putIfAbsent(index, new ArrayList<>());
                map.get(index).add(new Pair(node.val, level));

                if (node.left != null) {
                    queue.add(new Pair(node.left, index - 1));
                } 

                if (node.right != null) {
                    queue.add(new Pair(node.right, index + 1));
                } 
            }
            level++;
        }

        for (int i = min; i <= max; i++) {
            List<Pair<Integer, Integer>> currRes = map.get(i);
            
            Collections.sort(currRes, (a, b) -> {
                if (a.getValue() == b.getValue()) {
                    return a.getKey().compareTo(b.getKey());
                }
                return a.getValue().compareTo(b.getValue());
            });

            List<Integer> sortedRes = new ArrayList<>();
            for (Pair<Integer, Integer> pair: currRes) {
                sortedRes.add(pair.getKey());
            }

            res.add(sortedRes);
        }

        return res;
    }
}