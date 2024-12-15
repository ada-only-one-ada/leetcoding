class MinStack {
    Stack<int[]> stack;
    Stack<int[]> minStack;
    int index;
    Set<Integer> set;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
        index = 0;
        set = new HashSet<>();
    }
    
    public void push(int val) {
        stack.push(new int[]{index, val});
        
        if (minStack.isEmpty() || val <= minStack.peek()[1]) {
            minStack.push(new int[]{index, val});
        }
        index++;
    }
    
    public void pop() {
        int popedIndex = stack.pop()[0];
        if (minStack.peek()[0] == popedIndex) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek()[1];
    }
    
    public int getMin() {
        while (!minStack.isEmpty() && set.contains(minStack.peek()[0])) {
            set.remove(minStack.pop()[0]);
        }
        
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