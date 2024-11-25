class Solution {
    public long getDescentPeriods(int[] prices) {
        if (prices.length == 0) return 0;
        
        long res = prices.length;
        int prev = 1;
        
        for (int i = 1; i < prices.length; i++) {
            // 当前数字可以和之前的每个字数组都组成新的递减字数组
            if (prices[i - 1] - 1 == prices[i]) {
                res += prev;
                prev++;
            } else {            
                prev = 1;
            }
        } 

        return res;
    }
}