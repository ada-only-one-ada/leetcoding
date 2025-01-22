class Solution {
    public int bestClosingTime(String customers) {
        // 在某一时间点关门，计算那之前，没来的顾客
        int[] prevNo = new int[customers.length()];
        // 在0点关门，之前没有没来的顾客
        for (int i = 1; i < customers.length(); i++) {
            if (customers.charAt(i-1) == 'N') {
                prevNo[i] = prevNo[i-1] + 1; 
            } else {
                prevNo[i] = prevNo[i-1];
            }
        }

        // 在某一时间点关门，计算那之后，包括那一个点，来的顾客
        int[] afterYes = new int[customers.length()];
        // 最后一个点是 Y，那么那一个点来的顾客就是 1
        afterYes[afterYes.length - 1] = customers.charAt(customers.length() - 1) == 'Y'? 1: 0;
        for (int i = customers.length() - 2; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                afterYes[i] = afterYes[i+1] + 1;
            } else {
                afterYes[i] = afterYes[i+1];
            }
        }

        int res = -1;
        int minPenalty = Integer.MAX_VALUE;

        for (int i = 0; i < customers.length(); i++) {
            int no = prevNo[i]; // 关之前没来的
            int yes = afterYes[i]; // 关之后来了的

            if (no + yes < minPenalty) {
                minPenalty = no + yes;
                res = i;
            }
        }

        // 一个顾客也没来
        if (afterYes[0] < minPenalty) {
            return 0;
        }

        // 一直有顾客来
        if (prevNo[prevNo.length - 1] < minPenalty) {
            return prevNo.length;
        }
        
        return res;
    }
}
