/*
	算法思想：
		暴力
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0)
            return 0;
        int col = matrix[0].length;
        int maxArea = 0;
        //渐进累积到最后一层
        int[] height = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //渐进累积到最后一层，因此当为1的时候不能只是赋值为1
                if(matrix[i][j] == '1')
                    height[j] += 1;
                else
                    height[j] = 0;
            }
            maxArea = Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;
    }
	//84题解：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
    public int largestRectangleArea(int[] height){
        int sum = 0;
        for(int i=0;i<height.length;i++){
            int curHeight = height[i];
            int left = i;
            // 找左边最后 1 个大于等于 heights[i] 的下标
            while(left > 0 && height[left-1] >= curHeight){
                left--;
            }

            int right = i;
            while(right < height.length-1 && height[right+1] >= curHeight)
                right++;
            // int cursum = 
            sum = Math.max(sum,(right-left+1)*curHeight);
        }
        return sum;
    }
}

作者：wang-xue-lei-2
链接：https://leetcode-cn.com/problems/maximal-rectangle/solution/5ms-85tong-su-de-bao-li-jie-fa-8485ti-by-v4h0/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。