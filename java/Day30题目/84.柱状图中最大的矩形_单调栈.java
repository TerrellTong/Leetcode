/*
	算法思想：
		单调栈
	
	单调栈的思路：
		单调栈分为单调递增栈和单调递减栈
	11. 单调递增栈即栈内元素保持单调递增的栈
	12. 同理单调递减栈即栈内元素保持单调递减的栈

	操作规则（下面都以单调递增栈为例）
	21. 如果新的元素比栈顶元素大，就入栈
	22. 如果新的元素较小，那就一直把栈内元素弹出来，直到栈顶比新元素小

	加入这样一个规则之后，会有什么效果
	31. 栈内的元素是递增的
	32. 当元素出栈时，说明这个新元素是出栈元素向后找第一个比其小的元素


	33.当元素出栈后，说明新栈顶元素是出栈元素向前找第一个比其小的元素

	
	
*/
 
class Solution {
    public int largestRectangleArea(int[] heights) {
        //返回的结果值
        int res = 0;
        int[] new_heights = new int[heights.length+2];
        //声明一个栈
        Deque<Integer> stack = new ArrayDeque();
        //将heights转移到new_heights中，实现一一对应
        for(int i=1;i<heights.length+1;i++)
            new_heights[i] = heights[i-1];

        //开始遍历
        for(int i=0;i<new_heights.length;i++){
            //如果栈不空，并且栈顶的元素大于此时的height[i]值，就进行出栈，然后进行面积的计算
            while(!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]){
                int cur = stack.pop();
				//矩形的面积是，当前cur的高度 * 宽
                res = Math.max(res,(i - stack.peek() - 1)*new_heights[cur]);
            }
            //不管如何，都要入栈，
            //在经过上面的操作之后，相当于比height[i]大的值已经都出栈了，此时的栈还是个单调递增的栈
            //记录数组下标，他们实际对应的值是单调上升的
            stack.push(i);
        }
        return res;
    }
}









