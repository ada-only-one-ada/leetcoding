class Solution {
    public int[] rearrangeArray(int[] nums) {
        // every consecutive pair has diff signs
        // same sign, order matters
        // begin with positive

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int num: nums) {
            if (num >= 0) pos.add(num);
            else neg.add(num);
        }

        int[] res = new int[nums.length];
        int posIndex = 1;
        int negIndex = 0;
        int resIndex = 1;
        res[0] = pos.get(0);

        while (resIndex < res.length) {
            if (res[resIndex - 1] > 0) {
                res[resIndex++] = neg.get(negIndex++);
            } else {
                res[resIndex++] = pos.get(posIndex++);
            }
        }
        return res;
    }
}