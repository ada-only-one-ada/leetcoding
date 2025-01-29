class Solution {
    public int trap(int[] height) {
        // 左边第一个比它高的，右边第一个比它高的
        int[] h = new int[height.length + 2];
        for (int i = 0; i < height.length; i++) {
            h[i + 1] = height[i];
        }
        height = h;

        int res = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            if (stack.size() <= 2 || height[i] <= height[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() >= 2 && height[i] > height[stack.peek()]) {
                    int right = i;
                    int mid = stack.pop();
                    int left = stack.peek();

                    int currWidth = right - left - 1;
                    int currHeight = Math.min(height[right], height[left]);

                    int currArea = currWidth * currHeight - currWidth * height[mid];
                    if (currArea >  0) res += currArea;
                }
                stack.push(i);
            }
        }

        return res;
    }
}