/*
	算法思想：
		labuladong
		大小堆，注意添加元素不能盲目添加，我们也要维护large堆的堆顶元素要大于等于small堆的堆顶元素。！
		因此在往堆元素小的那个size添加元素时，我们先往对应的堆添加
		例如：想要往large里添加元素，不能直接添加，而是要先往small里添加，然后再把small的堆顶元素加到large中；向small中添加元素同理。
		
		PriorityQueue，默认小根堆，因为是从小到大进行递增的！！
*/


class MedianFinder {
    PriorityQueue<Integer> left_big;
    PriorityQueue<Integer> right_small;

    /** initialize your data structure here. */
    public MedianFinder() {
        //PriorityQueue默认是大根堆
        left_big = new PriorityQueue();
        //重写Comparator从而声明小根堆
        right_small = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
    }
    
    //addNum关键:维护两个堆元素之差不能超过1 ！！！而且也要维护large堆的堆顶元素要大于等于small堆的堆顶元素。
    //我们要往堆元素小的那个size，添加元素，但是不能盲目的添加元素，我们也要维护large堆的堆顶元素要大于等于small堆的堆顶元素。！
    public void addNum(int num) {
        //为了维持从大根堆到小根堆都是递增的关系，我们的add元素要进行取巧
        //如果左边的元素多，我们要先添加到左边元素，为了完成左右元素的平衡，同时需要将左堆的根顶放到右堆中
        if(left_big.size() > right_small.size()){
            left_big.add(num);
            right_small.add(left_big.poll());
        }else{
            right_small.add(num);
            left_big.add(right_small.poll());
        }
    }
    
    public double findMedian() {
        //如果两边元素不等，则中位数一定是元素多的那个！
        if(left_big.size() > right_small.size())
            return (double)left_big.peek();
        else if(left_big.size() < right_small.size())
            return (double)right_small.peek();
        return (left_big.peek() + right_small.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
 
 class MedianFinder {
    PriorityQueue<Integer> left_big;
    PriorityQueue<Integer> right_small;

    /** initialize your data structure here. */
    public MedianFinder() {
        //默认小根堆
        right_small = new PriorityQueue();
        left_big = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
    }
    
    public void addNum(int num) {
        if(left_big.size() >= right_small.size()){
            left_big.add(num);
            right_small.add(left_big.poll());
        }else{
            right_small.add(num);
            left_big.add(right_small.poll());
        }
    }
    
    public double findMedian() {
        if(left_big.size() > right_small.size())
            return (double)left_big.peek();
        else if(left_big.size() < right_small.size())
            return (double)right_small.peek();
        return (left_big.peek() + right_small.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */