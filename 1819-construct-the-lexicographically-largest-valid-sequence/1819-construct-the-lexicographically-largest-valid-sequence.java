class Solution {
    int[] res;
    int totalLen;

    public int[] constructDistancedSequence(int n) {
        totalLen = n * 2 - 1;
        res = new int[totalLen];
        backtracking(n, 0, new int[totalLen], new boolean[n + 1]);
        return res;
    }

    public boolean backtracking(int n, int index, int[] currRes, boolean[] used) {
        if (index == totalLen) {
            res = currRes;
            return true;
        }

        if (currRes[index] != 0) {
            return backtracking(n, index + 1, currRes, used);
        }

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            
            if (num == 1) {
                currRes[index] = 1;
                used[1] = true;
                if (backtracking(n, index + 1, currRes, used)) {
                    return true;
                }
                currRes[index] = 0;
                used[1] = false;
            } else if (num >= 2) {
                if (index + num >= totalLen || currRes[index + num] != 0) continue;
                currRes[index] = num;
                currRes[index + num] = num;
                used[num] = true;
                if (backtracking(n, index + 1, currRes, used)) {
                    return true;
                }
                currRes[index] = 0;
                currRes[index + num] = 0;
                used[num] = false;
            }
        }

        return false;
    }
}