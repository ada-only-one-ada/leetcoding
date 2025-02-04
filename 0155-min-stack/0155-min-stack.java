class MinStack {
    Stack<int[]> stack;
    Stack<int[]> minStack;
    int i;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();    
        i = 0;
    }
    
    public void push(int val) {
        stack.push(new int[]{i, val});

        if (minStack.isEmpty() || val <= minStack.peek()[1]) {
            minStack.push(new int[]{i, val});
        }
        i++;
    }
    
    public void pop() {
        int[] poped = stack.pop();
        if (minStack.peek()[0] == poped[0]) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek()[1];
    }
    
    public int getMin() {
        return minStack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */