/*
	算法思想：
		无法暴力AC（已经尝试）
		采用双端队列，用双端队列维护一个单调递减的值（队头最大，队尾最小）
		双端队列存放下标，从而还可以通过下标值来判断当前下标值，是否小于窗口的左端点，如果小于则弹出！！
		
题解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
	
	将前k个元素放入优先队列中，此时的堆顶元素就是最大值！然后将后面的元素依次放入大根堆，从而只需要判断堆顶元素是否满足滑动窗口的条件即可！
	https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/（大根堆）

*/

//优先级队列（大根堆思想），容易理解
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //声明一个二维数组的大根堆
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]==b[0] ? b[1]-a[1] : b[0]-a[0];
            }
        });
        //存放最后的res元素
        int[] res = new int[n-k+1];
        int index = 0;

        //将前k个元素放入优先队列中
        //(nums[i],i)数组表示nums[i]的下标
        for(int i=0;i<k;i++)
            pq.offer(new int[]{nums[i],i});
        //获取大根堆的堆顶
        res[index++] = pq.peek()[0];

        //将剩余的元素再次入堆
        for(int i=k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            //判断当前的大根堆的堆顶是否在滑动窗口中
            //如果不在，则一直弹出
            while(pq.peek()[1] <= i-k){
                pq.poll();
            }
            res[index++] = pq.peek()[0];
        }
        return res;
    }
}


//双端队列
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0)
            return new int[0];

        if(k == 1)
            return nums;

        Deque<Integer> queue = new LinkedList();
        List<Integer> list = new ArrayList();

        //遍历nums数组
        for(int i=0;i<nums.length;i++){
            //保证从大到小的队列
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            //将当前值的下标添加到queue中
            queue.addLast(i);
            //判断队首的值是否过期了（即该下标值已经被移除了）
            
            //此时已经形成了窗口
            if(i+1 >= k){
                list.add(nums[queue.peek()]);
                //判断当前队头存放的下标值是否已经过期
                //i+1-k  对应的是滑动窗口的左边界
                if(queue.peek() <= (i+1-k))
                    queue.poll();
            }
        }

        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}