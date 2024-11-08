class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        int[] allow = new int[1001];

        for (int ans: answers) {
            if (allow[ans] == 0) {
                res += ans + 1;
                allow[ans] = ans;
            } else {
                if (allow[ans] > 0) {
                    allow[ans]--;
                } else if (allow[ans] <= 0) {
                    res += ans + 1;
                    allow[ans] = ans;
                }
            }
        }
        return res;
    }
}