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
	
	解法四：分别求出包含每个柱子的矩形区域的最大面积，然后选最大的。要包含这个柱子，也就是这个柱子是当前矩形区域的高度。
			也就是，这个柱子是当前矩形区域中柱子最高的。如下图中包含橙色柱子的矩形区域的最大面积。
			求当前的矩形区域，我们只需要知道比当前柱子到左边第一个小的 leftLessMin 和到右边第一个小的 rightLessMin 两个柱子下标，
			就可以求出矩形的面积为 (rightLessMin - leftLessMin - 1) * 当前柱子高度。然后遍历每个柱子，按同样的方法求出矩形面积，选最大的就可以了。

原理：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-7/
	
	
*/
 
public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    int p = 0;
    while (p < heights.length) {
        //栈空入栈
        if (stack.isEmpty()) {
            stack.push(p);
            p++;
        } else {
            int top = stack.peek();
            //当前高度大于栈顶，入栈
            if (heights[p] >= heights[top]) {
                stack.push(p);
                p++;
            } else {
                //保存栈顶高度
                int height = heights[stack.pop()];
                //左边第一个小于当前柱子的下标
                int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                //右边第一个小于当前柱子的下标
                int RightLessMin = p;
                //计算面积
                int area = (RightLessMin - leftLessMin - 1) * height;
                maxArea = Math.max(area, maxArea);
            }
        }
    }
    while (!stack.isEmpty()) {
        //保存栈顶高度
        int height = heights[stack.pop()];
        //左边第一个小于当前柱子的下标
        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
        //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
        int RightLessMin = heights.length;
        int area = (RightLessMin - leftLessMin - 1) * height;
        maxArea = Math.max(area, maxArea);
    }
    return maxArea;
}

作者：windliang
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。









