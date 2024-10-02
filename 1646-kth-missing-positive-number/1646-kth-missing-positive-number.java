class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k <= arr[0] - 1) return k;

        k -= arr[0] - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int missingFound = arr[i + 1] - arr[i] - 1; 
            
            if (k <= missingFound) {
                return arr[i] + k;
            }
           
            k -= missingFound;
        }

        return arr[arr.length - 1] + k;
    }
}