/*
	算法思想：
		
*/
class CQueue {
    Stack<Integer> t_stack;
    Stack<Integer> h_stack;

    public CQueue() {
        t_stack = new Stack<Integer>();
        h_stack = new Stack<Integer>();
    }


    public void appendTail(int value) {
        t_stack.push(value);
    }
    
    public int deleteHead() {
        //如果尾部栈为空
        if(h_stack.isEmpty()){
            while(!t_stack.isEmpty()){
                int value = t_stack.pop();
                h_stack.push(value);
            }
        }
        if(h_stack.isEmpty())
            return -1;
        return h_stack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
    





