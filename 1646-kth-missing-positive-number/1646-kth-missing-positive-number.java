class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0]) return k;

        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int totalFound = arr[mid] - mid - 1;

            if (totalFound >= k) {
                end = mid;
            } else {
                start = mid + 1;
            } 
        }

        if (start == arr.length) {
            return arr[start - 1] + (k - (arr[start - 1] - start));
        } else {
            return arr[start - 1] + (k - (arr[start - 1] - (start - 1))) + 1;
        }
    }
}