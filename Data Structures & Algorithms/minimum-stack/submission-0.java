class MinStack {

    // Each stack: [value, currentMin]
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(new int[]{val,val});
        } else {
            int currentMin = stack.peek()[1];
            int newMin = Math.min(val, currentMin);
            stack.push(new int[]{val, newMin});
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            // why not stack.pop()[0]?
        } 
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
