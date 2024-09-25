class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex];

            int currArea = Math.min(leftHeight, rightHeight) * (rightIndex - leftIndex);
            max = Math.max(max, currArea);
            if (leftHeight >= rightHeight) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        // this is tests
        return max;
    }
}