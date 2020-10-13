/*
	算法思想：
		与84，类似，只不过是将height进行了隐藏
		单调栈！
		解法四：分别求出包含每个柱子的矩形区域的最大面积，然后选最大的。要包含这个柱子，也就是这个柱子是当前矩形区域的高度。
		也就是，这个柱子是当前矩形区域中柱子最高的。如下图中包含橙色柱子的矩形区域的最大面积。
		求当前的矩形区域，我们只需要知道比当前柱子到左边第一个小的 leftLessMin 和到右边第一个小的 rightLessMin 两个柱子下标，就可以求出矩形的面积为 (rightLessMin - leftLessMin - 1) * 当前柱子高度。然后遍历每个柱子，按同样的方法求出矩形面积，选最大的就可以了。


		
		
题解：https://leetcode-cn.com/problems/maximal-rectangle/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-8/
https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-7/
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for(int row = 0;row < matrix.length;row++){
            //遍历每一列，更新高度
            for(int col = 0;col<matrix[0].length;col++){
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                }
                else {
                    heights[col] = 0;
                }
            }

            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights){
        int maxArea = 0;
        Stack<Integer> stack = new Stack();
        int p = 0;
        while(p < heights.length){
            //栈空入栈
            if(stack.isEmpty()){
                stack.push(p);
                p++;
            }else{
                int top = stack.peek();
                //当前高度大于栈顶，入栈
                if(heights[p] >= heights[top]){
                    stack.push(p);
                    p++;
                }else{
                    //保存栈顶的高度
					//作为矩形的高
                    int height = heights[stack.pop()];
                    //左边第一个小于当前柱子的下标
                    int leftLessMin = stack.isEmpty()?-1:stack.peek();
                    //右边第一个小于当前柱子的下标
                    int RightLessMin = p;
                    //计算面积
                    int area = (RightLessMin-leftLessMin-1)*height;
                    maxArea = Math.max(area,maxArea);
                }
            }
        }

        while(!stack.isEmpty()){
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
}
