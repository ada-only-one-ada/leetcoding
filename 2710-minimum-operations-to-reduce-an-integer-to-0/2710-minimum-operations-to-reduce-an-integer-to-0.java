class Solution {
    public int minOperations(int n) {
        int count = 0;
        while (n != 0) {
            int cloestExponent = getCloestExponent(n);
            n = Math.abs(n - (int)Math.pow(2, cloestExponent));
            count++;
        }

        return count;
    }

    public int getCloestExponent(int n) {
        return (int) Math.round(Math.log(n) / Math.log(2));
    }
}

