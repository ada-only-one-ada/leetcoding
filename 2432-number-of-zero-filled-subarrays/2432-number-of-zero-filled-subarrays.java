class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long currZeroCount = 0;

        for (int num: nums) {
            if (num == 0) {
                currZeroCount++;
            } else {
                currZeroCount = 0;
            }
            res += currZeroCount;
        }

        return res;
    }
}

/*
[1,3,0,0,2,0,0,4]
[0,0,1,1,0,1,1,0]
[0,0,1,2,0,1,2,0]
[0,0,1,3,0,1,3,0]
*/