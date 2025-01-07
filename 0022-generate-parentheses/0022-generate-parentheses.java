class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, res, "");
        return res;
    }

    public void dfs(int n, int left, int right, List<String> res, String currRes) {
        if (left == n && right == n) {
            res.add(currRes);
        }
        if (left > n || right > n) return;

        if (left < n) {
            dfs(n, left + 1, right, res, currRes + "(");
        }

        if (right < n && left > right) {
            dfs(n, left, right + 1, res, currRes + ")");
        }
    }
}