class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
       
        int leftover = 0;
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            int n = i >= 0? num[i] : 0;
            if (i >= 0) i--;

            int sum = n + (k % 10) + leftover;

            res.add(sum % 10);
            leftover = sum / 10;
            k = k / 10;
        }

        if (leftover > 0) res.add(leftover);
        Collections.reverse(res);
        return res;
    }
}