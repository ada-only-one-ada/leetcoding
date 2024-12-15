class MinStack {
    Stack<Integer> stack;
    int min;

    // 如果当前min被pop了，需要拿到下一个min，我们可以把下一个min放在能拿到的位置
    public MinStack() {
        stack = new Stack();    
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val > min) {
            stack.push(val);
        } else {
            stack.push(min); // 当前的min放在val下面，变成了下一个min的candidate，这个不是实际的数字，是做reference的作用
            stack.push(val);
            min = val;
        }
    }
    
    public void pop() {
        int popedNum = stack.peek();
        // 如果扔掉的这个数字是最小值
        if (popedNum == min) {
            // 先把这个数字扔了
            stack.pop();
            // 然后更新 min 为下一个 min 的 candidate
            min = stack.pop(); // 把 reference 也扔了
        // 如果扔掉的这个数字不是最小值，那么不需要更新 min
        } else {
            // 直接扔掉这个数字
            stack.pop();
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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