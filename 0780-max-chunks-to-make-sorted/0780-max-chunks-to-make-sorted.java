class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack();

        // increasing : 1 2 3 4
        // 4
    
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
                stack.push(i);
            } else {
                int max = stack.peek();
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    stack.pop();
                }
                stack.push(max);
            }
        }

        return stack.size();
    }
}