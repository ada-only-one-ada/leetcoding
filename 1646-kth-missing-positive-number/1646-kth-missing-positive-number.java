class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0]) return k;

        int totalInterval = arr[0] - 1;

        for (int i = 1; i < arr.length; i++) {
            int start = arr[i - 1];
            int end = arr[i];
            int currTotalMissing = end - start - 1;

            if (totalInterval + currTotalMissing >= k) {
                return (k - totalInterval) + start;
            } 
                
            totalInterval += currTotalMissing;
        }

        return arr[arr.length - 1] + (k - totalInterval);
    }
}