class Solution {
    public int arraySign(int[] nums) {
        int zero = 0;
        int pos = 0;
        int neg = 0;

        for (int num: nums) {
            if (num == 0) {
                zero++;
            } else if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }

        if (zero > 0) {
            return 0;
        } else if (neg % 2 == 0) {
            return 1;
        } 

        return -1;
    }
}