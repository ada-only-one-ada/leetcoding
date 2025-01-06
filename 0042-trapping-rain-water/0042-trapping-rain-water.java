class Solution {
    public int trap(int[] height) {
        // 左边第一个比它高的，右边第一个比它高的
        // [2,1,0,1,    3]
        int sumArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() >= 2 && height[i] > height[stack.peek()]) {
                    int rightIndex = i;
                    int midIndex = stack.pop();
                    int leftIndex = stack.peek();

                    int h = Math.min(height[leftIndex], height[rightIndex]);
                    int w = rightIndex - leftIndex - 1;
                    int midh = height[midIndex];

                    int area = h * w - midh * w;
                    if (area > 0) sumArea += area;
                }
                stack.push(i);
            }
        }

        return sumArea;
    }
}