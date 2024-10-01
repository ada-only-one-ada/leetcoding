class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0]) return k;

        int totalFound = arr[0] - 1;

        for (int i = 1; i < arr.length; i++) {
            int start = arr[i - 1];
            int end = arr[i];
            
            int currFound = end - start - 1;

            if (totalFound + currFound >= k) {
                return (k - totalFound) + start;
            } 
                
            totalFound += currFound;
        }

        return arr[arr.length - 1] + (k - totalFound);
    }
}