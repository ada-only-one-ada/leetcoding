class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtracking(n, k, new ArrayList<>(), 1);
        return res;
    }

    public void backtracking(int n, int k, List<Integer> currRes, int currNumber) {
        if (currRes.size() == k) {
            res.add(new ArrayList<>(currRes));
            return;
        }
        if (currNumber == n + 1) return;

        for (int i = currNumber; i <= n; i++) {
            currRes.add(i);
            backtracking(n, k, currRes, i + 1);
            currRes.remove(currRes.size() - 1);
        }
    }
}