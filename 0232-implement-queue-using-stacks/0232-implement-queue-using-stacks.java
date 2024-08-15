class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> tempStack;

    public MyQueue() {
        stack = new Stack();
        tempStack = new Stack();
    }
    
    public void push(int x) {
        tempStack.push(x);
    }
    
    public int pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return stack.pop();
        }
    }
    
    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return stack.peek();
        }
    }
    
    public boolean empty() {
        return stack.isEmpty() && tempStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */