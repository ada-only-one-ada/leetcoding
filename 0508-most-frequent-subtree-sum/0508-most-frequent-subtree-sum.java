class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();

        int maxFreq = 0;
        for (int sum: map.keySet()) {
            if (map.get(sum) >= maxFreq) {
                if (map.get(sum) > maxFreq) {
                    maxFreq = map.get(sum);
                    list.clear();
                }
                list.add(sum);   
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }   

        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}