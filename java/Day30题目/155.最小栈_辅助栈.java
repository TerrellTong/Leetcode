/*
	算法思想：
		辅助栈
*/
 
class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int x) {
        //压入数据栈
        dataStack.push(x);
        //如果入栈的元素为最小值，则也要压入辅助栈
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }
    
    public void pop() {
        //先删除数据栈
        int x = dataStack.pop();
        //如果x是最小值，也要删除最小栈里面的值
        if(x == minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */











