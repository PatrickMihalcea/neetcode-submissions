class MinStack {

    private Stack<int[]> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        int[] entry = new int[] {val, min};
        stack.push(entry);
        min = Math.min(min, val);
    }
    
    public void pop() {
        min = stack.pop()[1];
    }
    
    public int top() {
        return stack.peek()[0];
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