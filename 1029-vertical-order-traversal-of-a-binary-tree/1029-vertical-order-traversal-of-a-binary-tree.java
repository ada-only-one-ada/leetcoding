class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Pair<TreeNode, int[]>> queue = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();

        queue.add(new Pair(root, new int[]{0, 0}));
        int minColumn = Integer.MAX_VALUE;
        int maxColumn = Integer.MIN_VALUE;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, int[]> curr = queue.poll();
                TreeNode currNode = curr.getKey();
                int[] columnLevel = curr.getValue();
                int column = columnLevel[0];
                int level = columnLevel[1];

                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                if (!map.containsKey(column)) {
                    map.put(column, new HashMap<>());
                }

                if (!map.get(column).containsKey(level)) {
                    map.get(column).put(level, new ArrayList<>());
                }

                map.get(column).get(level).add(currNode.val);

                if (currNode.left != null) {
                    queue.add(new Pair(currNode.left, new int[]{column - 1, level + 1}));
                }

                if (currNode.right != null) {
                    queue.add(new Pair(currNode.right, new int[]{column + 1, level + 1}));
                }
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            Map<Integer, List<Integer>> subMap = map.get(i);

            List<Integer> currRes = new ArrayList<>();
            int minLevel = Integer.MAX_VALUE;
            int maxLevel = Integer.MIN_VALUE;

            for (int level: subMap.keySet()) {
                minLevel = Math.min(minLevel, level);
                maxLevel = Math.max(maxLevel, level);
            }

            for (int level = minLevel; level <= maxLevel; level++) {
                List<Integer> list = subMap.get(level);
                if (list == null) continue;
                Collections.sort(list);
                for (int num: list) {
                    currRes.add(num);
                }   
            }

            res.add(currRes);
        }

        return res;
    }
}