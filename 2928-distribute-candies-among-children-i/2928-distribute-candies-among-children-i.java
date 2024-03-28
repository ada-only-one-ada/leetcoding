class Solution {
    int res = 0;
    public int distributeCandies(int n, int limit) {
        backtracking(n, limit, new ArrayList<>(), 0);

        return res;
    }

    public void backtracking(int n, int limit, List<Integer> currRes, int currSum) {
        if (currRes.size() == 3) {
            if (currSum == n) {
                res++;
            }
            return;
        }

        for (int i = 0; i <= limit; i++) {
            currSum += i;
            currRes.add(i);

            backtracking(n, limit, currRes, currSum);

            currSum -= i;
            currRes.remove(currRes.size() - 1);
        }
    }
}