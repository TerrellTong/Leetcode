/*
	算法思想：
		用大根堆，小顶堆的思想，注意如果大根堆，小顶堆的size不满足K/2，则要调整！！！
		与239.滑动窗口的最大值题目类似！！！！
		
	题解：https://leetcode-cn.com/problems/sliding-window-median/solution/xiang-jie-po-su-jie-fa-you-xian-dui-lie-mo397/
*/


class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        //数据流的中位数的思想，大小根堆,左边放大根堆,右边放小根堆，从而大小根堆的堆顶的一半就是我们要的中位数
		//对于出现溢出int的数值，我们用Integer.compare()进行比较
        PriorityQueue<Integer> left_big = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return Integer.compare(b,a);
            }
        });
        PriorityQueue<Integer> right_small = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return Integer.compare(a,b);
            }
        });
        int n = nums.length;
        int cnt = n-k+1;
        double[] ans = new double[cnt];

        int index = 0;
        //将k个元素先全部放入right_small中，再从right_small堆中，弹出K/2个元素到左边的大根堆中
        for(int i=0;i<k;i++)
            right_small.add(nums[i]);
        for(int i=0;i<k/2;i++)
            left_big.add(right_small.poll());
        //获取大小根堆的堆顶元素，然后将其返回
        ans[index++] = getMid(left_big,right_small);
        //相当于进行窗口的移动
        for(int i=k;i<n;i++){
            //del表示要被删除的元素
            int add = nums[i],del = nums[i-k];
            //如果要添加的元素比右边的小根堆的最小元素还小，则加入右根堆
            if(add >= right_small.peek())
                right_small.add(add);
            else
                left_big.add(add);
            //删除元素，找到这个元素是在大根堆还是小根堆
            if(del >= right_small.peek())
                right_small.remove(del);
            else
                left_big.remove(del);
            //调整元素
            adjust(left_big,right_small);
            ans[index++] = getMid(left_big,right_small);
        }
        return ans;   
    }

    //为了让大根堆，小根堆都满足K/2的关系
    public void adjust(PriorityQueue<Integer> left_big,PriorityQueue<Integer> right_small){
        while(left_big.size() > right_small.size())
            right_small.add(left_big.poll());
        while(right_small.size() - left_big.size() > 1)
            left_big.add(right_small.poll());
    }

    public double getMid(PriorityQueue<Integer> left,PriorityQueue<Integer> right){
        //此时是偶数，要取一半
        if(left.size() == right.size())
            return (left.peek() / 2.0) + (right.peek() / 2.0);
        else    
            return right.peek() * 1.0;
    }
}