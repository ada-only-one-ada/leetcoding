class Solution {
    public int numTeams(int[] rating) {
        int res = 0;

        for (int i = 0; i < rating.length; i++) {
            int[] freq = count(rating, i);
            // 左边比他小的人数 × 右边比他大的人数 + 左边比他大的人数 × 右边比他小的人数
            res += freq[0] * freq[3] + freq[1] * freq[2];
        }
       
        return res;
    }

    public int[] count(int[] rating, int index) {
        // 【左边比它小，左边比它大，右边比它小，右边比它大】
        int[] res = new int[4];

        for (int i = 0; i < index; i++) {
            if (rating[i] < rating[index]) {
                res[0]++;
            } else if (rating[i] > rating[index]) {
                res[1]++;
            }
        }

        for (int i = index + 1; i < rating.length; i++) {
            if (rating[i] < rating[index]) {
                res[2]++;
            } else if (rating[i] > rating[index]) {
                res[3]++;
            }
        }

        return res;
    }
}