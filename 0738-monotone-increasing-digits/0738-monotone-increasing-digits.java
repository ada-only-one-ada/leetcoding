class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        // 15632
        // 15522 
        int marker = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                arr[i - 1]--;
                marker = i;
            }
        }

        if (marker == -1) return n;

        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (i < marker) {
                res += arr[i];
            } else {
                res += '9';
            }
        }

        return Integer.parseInt(res);
    }
}