class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];

        int[] freq = new int[A.length + 1];
        int common = 0;

        for (int i = 0; i < A.length; i++) {
            int numA = A[i];
            int numB = B[i];

            freq[numA]++;
            if (freq[numA] == 2) common++;

            freq[numB]++;
            if (freq[numB] == 2) common++;

            res[i] = common;
        }
        return res;
    }
}