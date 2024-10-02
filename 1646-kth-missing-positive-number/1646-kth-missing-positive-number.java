class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0]) return k;

        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int foundUntilMid = arr[mid] - mid - 1;

            if (foundUntilMid < k) {
                start = mid + 1;
            } else {
                end = mid;
            } 
        }

        int foundUntilStart = arr[start - 1] - (start - 1) - 1;
        return arr[start - 1] + (k - foundUntilStart);
    }
}