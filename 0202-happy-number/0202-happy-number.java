class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            int next = getSum(n);
            if (next == 1) return true;
            if (set.contains(next)) break;
            set.add(n);
            n = next;
        }

        return n == 1;
    }

    public int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}