class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // It is guaranteed that A and B are both a permutation of n integers.
        // 这意味着里面出现的数字一定是2次
        
        // 1 <= A[i], B[i] <= n
        int n = A.length;

        int[] res = new int[n];
        int[] freq = new int[n + 1];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            int numA = A[i];
            int numB = B[i];

            freq[numA]++;
            if (freq[numA] == 2) {
                commonCount++;
            }

            freq[numB]++;
            if (freq[numB] == 2) {
                commonCount++;
            }

            res[i] = commonCount;
        }

        return res;
    }
}