class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;

        while (i < numbers.length - 1) {
            int left = i + 1;
            int right = numbers.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int sum = numbers[i] + numbers[mid];

                if (sum == target) {
                    return new int[]{i + 1, mid + 1};
                } else if (sum < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            i++;
        }

        return new int[0];
    }
}