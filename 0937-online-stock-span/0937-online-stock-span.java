class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack();    
    }
    
    public int next(int price) {
        int res = 1; // 起码这个price今天是等于自己的

        int prev = 0;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            prev += stack.pop()[1];   
        }
        
        stack.push(new int[]{price, res + prev});
        return res + prev;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */