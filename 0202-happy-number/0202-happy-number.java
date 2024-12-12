class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSum(n);

        while (slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));

            if (fast == 1) {
                return true;
            }

            if (slow == fast) {
                break;
            }
        }

        return fast == 1;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }
}