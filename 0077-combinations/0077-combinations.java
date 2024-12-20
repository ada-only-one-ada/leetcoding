class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    public void backtracking(int n, int k, List<List<Integer>> res, List<Integer> currRes, int newC) {
        if (currRes.size() == k) {
            res.add(new ArrayList<>(currRes));
            return;
        }

        // cut subtrees
        // k - currRes.size(): how many numbers we still need to look for 
        // e.g. n = 4, k = 3. currently currRes is 0, i can go to the right at most 2, so it will have 2,3,4
        // it i goes to 3, it only have two numbers left, can't find three numbers. So we cut it here
        // 4 - (3 - 0) + 1:
        // 4 - we still need to look for 3 numbers + 1
        // (4 - 3) + 1 = 1 + 1 = 2. 2 is included! [2,3,4]
        for (int i = newC; i <= n - (k - currRes.size()) + 1; i++) {
            currRes.add(i);
            backtracking(n, k, res, currRes, i + 1);
            currRes.remove(currRes.size() - 1);
        }
    }
}