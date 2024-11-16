class Solution {
    int totalLen;
    int[] res;

    public int[] constructDistancedSequence(int n) {
        totalLen = n * 2 - 1;
        res = new int[totalLen];
        int[] currRes = new int[totalLen];
        boolean[] usedNums = new boolean[n + 1];
        // 找到一个有效的，立刻返回，因为此时是字典序最大
        if (backtracking(n, currRes, 0, usedNums)) {
            return res;
        }

        return res;
    }

    public boolean backtracking(int n, int[] currRes, int index, boolean[] usedNums) {
        // 找到一个有效答案
        if (index == totalLen) {
            System.arraycopy(currRes, 0, res, 0, totalLen);
            return true;
        }

        // 当前位置已经被填过了
        if (currRes[index] != 0) {
            return backtracking(n, currRes, index + 1, usedNums);
        }

        // 从最大的开始填
        for (int num = n; num >= 1; num--) {
            // 当前数字已经被填过了，找下一个最大的填
            if (usedNums[num]) continue; 

            // 当前数字没有被填过，看能不能填：
            // 情况1：如果数字等于1，只要放在当前index就可以
            if (num == 1) {
                currRes[index] = num;
                usedNums[num] = true;
                // 这里一旦找到一个正确的立刻返回，因为需要字典序最大
                if (backtracking(n, currRes, index + 1, usedNums)) {
                    return true;
                }
                currRes[index] = 0;
                usedNums[num] = false;
            // 情况2：如果数字大于1，检查当前index和配对的index
            } else if (num >= 2) {
                // 如果配对的index越界，或者已经被占用了，这个数字填不了
                if (index + num >= totalLen || currRes[index + num] != 0) continue;

                currRes[index] = num;
                currRes[index + num] = num;
                usedNums[num] = true;
                // 这里一旦找到一个正确的立刻返回，因为需要字典序最大
                if (backtracking(n, currRes, index + 1, usedNums)) {
                    return true;
                }

                currRes[index] = 0;
                currRes[index + num] = 0;
                usedNums[num] = false;
            }
        }

        return false;
    }
}