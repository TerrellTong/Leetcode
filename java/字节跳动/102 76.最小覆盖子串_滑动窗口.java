/*
	算法思想：
		无法暴力AC（已经尝试）
		采用双端队列，用双端队列维护一个单调递减的值（队头最大，队尾最小）
		双端队列存放下标，从而还可以通过下标值来判断当前下标值，是否小于窗口的左端点，如果小于则弹出！！
		
题解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/

*/


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