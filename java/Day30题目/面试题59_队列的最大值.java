 /*
	算法思想：
	声明一个队列，用于存储值，
	一个双端队列，用于取最大值，实现了单调递减
	那么如何高效实现一个始终递减的队列呢？我们只需要在插入每一个元素 value 时，
	从队列尾部依次取出比当前元素 value 小的元素，直到遇到一个比当前元素大的元素 value' 即可。

 */
class MaxQueue {
   
     Queue<Integer> queue = new LinkedList<>();
    //声明一个双端队列,双端队列实现单调递减的队列
    Deque<Integer> deque = new LinkedList<>();
    public MaxQueue() {
       
    }
    
    public int max_value() {
        if(!deque.isEmpty())
            return deque.peekFirst();
        else
            return -1;
    }

    public void push_back(int value) {
        //如果队尾小于value，则deque的队尾出队
        while(!deque.isEmpty() && value > deque.peekLast()){
            deque.pollLast();
        }
        //queue和deque入队
        queue.offer(value);
        deque.offerLast(value);
    }
    
    public int pop_front() {
         if(queue.isEmpty())
            return -1;
        int a = queue.poll();
		//此处代码是有可能queue的队首是max,pop_front之后，如果没有在deque中删除这条记录，那么会到导致deque和queue数据不同步
        if(!deque.isEmpty()&&deque.peekFirst()==a){
               deque.pollFirst();
           }
        return a;
    }
}
