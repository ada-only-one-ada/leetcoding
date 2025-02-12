class Solution {
    public int minSwaps(int[] data) {
        int res = Integer.MAX_VALUE;

        int len = 0;
        for (int d: data) {
            len += d;
        }

        int zeros = 0;
        int left = 0;
        for (int right = 0; right < data.length; right++) {
            if (data[right] == 0) zeros++;

            if (right - left + 1 == len) {
                res = Math.min(res, zeros);

                if (data[left] == 0) {
                zeros--;
            }
            left ++;
            }
            
        }        

        return res == Integer.MAX_VALUE? 0 :res;
    }
}