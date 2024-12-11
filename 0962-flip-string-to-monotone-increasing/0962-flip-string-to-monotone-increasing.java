class Solution {
    public int minFlipsMonoIncr(String s) {
        // edge case: 1001110011

        /* 
          当遍历到0 选择保留 那么之前的1设为0 选择不保留 反转次数+1 取两者较小值即可。

          根据题意，0左边不能有任何1，比如：0000111
          当前字符是0，保留这个0，那么之前的1都要反转；
          当前字符是0，不保留这个0，即反转这个0变成1，
          两者取小值
        */

        int res = 0;

        int ones = 0;
        for (char num: s.toCharArray()) {
            if (num == '1') {
                ones++;
            } else if (num == '0') {
                // res 是之前都是妥善处理过的string，加上当前这次反转0为1
                res = Math.min(res + 1, ones);   
            }
        }

        return res;
    }
}