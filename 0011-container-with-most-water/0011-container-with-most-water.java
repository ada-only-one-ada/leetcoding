class Solution {
    public int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxWater = Math.max(maxWater, height[left] * (right - left));
                left++;
            } else {
                maxWater = Math.max(maxWater, height[right] * (right - left));
                right--;
            }
        }

        return maxWater;
    }
}