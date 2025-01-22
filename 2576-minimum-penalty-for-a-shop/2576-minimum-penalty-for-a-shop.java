
class Solution {
    public int bestClosingTime(String customers) {
        /* 规则：
           1.关门之前有人最多，无人最少
           2.关门之后无人最多，有人最少
        */
        
        int[] yesBefore = new int[customers.length() + 1];
        for (int i = 1; i < yesBefore.length; i++) {
            if (customers.charAt(i-1) == 'Y') {
                yesBefore[i] = yesBefore[i-1] + 1;
            } else {
                yesBefore[i] = yesBefore[i-1];
            }
        }     

        int res = yesBefore.length - 1;
        int max = yesBefore[yesBefore.length - 1]; 
        
        int[] noAfter = new int[customers.length() + 1];
        for (int i = noAfter.length - 2; i >= 0; i--) {
            if (customers.charAt(i) == 'N') {
                noAfter[i] = noAfter[i+1] + 1;
            } else {
                noAfter[i] = noAfter[i+1];
            }

            yesBefore[i] += noAfter[i];
            if (yesBefore[i] >= max) {
                res = i;
                max = yesBefore[i];
            }
        }

        return res;
    }
}