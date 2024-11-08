class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        int[] allow = new int[1000];

        for (int ans: answers) {
            if (allow[ans] <= 0) {
                res += ans + 1;
                allow[ans] = ans;
            } else {
                allow[ans]--;
            }
        }
        return res;
    }
}