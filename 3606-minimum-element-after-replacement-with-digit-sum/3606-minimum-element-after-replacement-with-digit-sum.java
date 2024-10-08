class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            min = Math.min(min, sumOfDigits(num));
        }

        return min;
    }

    public int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }
}