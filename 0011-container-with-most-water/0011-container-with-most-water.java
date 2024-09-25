class Solution {
    public int maxArea(int[] height) {
        int big = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex];

            int currArea = Math.min(leftHeight, rightHeight) * (rightIndex - leftIndex);
             big  = Math.max( big , currArea);
            if (leftHeight >= rightHeight) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
       
        return  big ;
    }
}