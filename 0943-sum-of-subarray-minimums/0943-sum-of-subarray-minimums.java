class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i - 1;
            while (left >= 0 && arr[left] >= arr[i]) {
                left--;
            }
            
            int right = i + 1;
            while (right < arr.length && arr[right] > arr[i]) {
                right++;
            }

            res += (long)arr[i] * (i - left) * (right - i);
        }

        return (int)(res % 1000000007);
    }
}