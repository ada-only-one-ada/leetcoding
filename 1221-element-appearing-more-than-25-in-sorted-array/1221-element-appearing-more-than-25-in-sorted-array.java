class Solution {
    public int findSpecialInteger(int[] arr) {
        int size = arr.length / 4;

        for (int i = 0; i + size < arr.length; i++) {
            if (arr[i] == arr[i + size]) {
                return arr[i];
            }
        }

        return -1;
    }
}