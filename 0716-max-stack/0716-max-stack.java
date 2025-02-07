class MaxStack {
    int id;
    Stack<int[]> stack;
    Queue<int[]> queue;
    Set<Integer> set;

    public MaxStack() {
        id = 0;
        stack = new Stack();
        queue = new PriorityQueue<>((a, b)-> {
            if (b[1] == a[1]) return b[0]-a[0];
            return b[1] - a[1];
        });
        set = new HashSet<>();
    }
    
    public void push(int x) {
        while (!stack.isEmpty() && set.contains(stack.peek()[0])) {
            stack.pop();
        }
        stack.push(new int[]{id, x});
        queue.add(new int[]{id, x});
        id++;
    }
    
    public int pop() {
        while (!stack.isEmpty() && set.contains(stack.peek()[0])) {
            stack.pop();
        }

        int[] removed = stack.pop();
        int removedIndex = removed[0];
        set.add(removedIndex);
        return removed[1];
    }
    
    public int top() {
        while (!stack.isEmpty() && set.contains(stack.peek()[0])) {
            stack.pop();
        }
        return stack.peek()[1];
    }
    
    public int peekMax() {
        while (!queue.isEmpty() && set.contains(queue.peek()[0])) {
            queue.poll();
        }
        return queue.peek()[1];
    }
    
    public int popMax() {
        while (!queue.isEmpty() && set.contains(queue.peek()[0])) {
            queue.poll();
        }

        int[] removed = queue.poll();
        set.add(removed[0]);
        return removed[1];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */