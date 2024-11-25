class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] lessLeft = new int[n];
        int[] greaterLeft = new int[n];
        int[] lessRight = new int[n];
        int[] greaterRight = new int[n];
        
        // 从左到右计算每个元素的 lessLeft 和 greaterLeft
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    lessLeft[i]++;
                } else if (rating[j] > rating[i]) {
                    greaterLeft[i]++;
                }
            }
        }

        // 从右到左计算每个元素的 lessRight 和 greaterRight
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (rating[j] < rating[i]) {
                    lessRight[i]++;
                } else if (rating[j] > rating[i]) {
                    greaterRight[i]++;
                }
            }
        }

        // 计算结果
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += lessLeft[i] * greaterRight[i] + greaterLeft[i] * lessRight[i];
        }

        return res;
    }
}
