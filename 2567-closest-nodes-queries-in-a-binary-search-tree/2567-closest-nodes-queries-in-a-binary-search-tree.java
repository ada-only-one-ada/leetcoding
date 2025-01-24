class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>>  res = new ArrayList();

        List<Integer> values = new ArrayList<>();
        addValues(root, values);
        Collections.sort(values);

        for (int query: queries) {
            int less = findLastLess(values, query);
            int more = findFirstMore(values, query);

            res.add(new ArrayList(Arrays.asList(less, more)));
        }

        return res;
    }

    public int findLastLess(List<Integer> values, int query) {
        int left = 0;
        int right = values.size();

        int res = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid) == query) {
                return query;
            } else if (values.get(mid) < query) {
                res = values.get(mid);
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;
    }

    public int findFirstMore(List<Integer> values, int query) {
        int left = 0;
        int right = values.size();

        int res = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid) == query) {
                return query;
            } else if (values.get(mid) > query) {
                res = values.get(mid);
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public void addValues(TreeNode root, List<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        addValues(root.left, values);
        addValues(root.right, values);
    }
}