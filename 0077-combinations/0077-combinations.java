class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtracking(n, k, new ArrayList<>(), 1);
        return res;
    }

    public void backtracking(int n, int k, List<Integer> currRes, int currNumber) {
        // 先收获，不然包含最后一个数字 n 的组合不会加入结果集
        if (currRes.size() == k) {
            res.add(new ArrayList<>(currRes));
            return;
        }
        
        // 再判断当前数字能不能加
        if (currNumber == n + 1) return;

        for (int i = currNumber; i <= n; i++) {
            currRes.add(i);
            backtracking(n, k, currRes, i + 1);
            currRes.remove(currRes.size() - 1);
        }
    }
}