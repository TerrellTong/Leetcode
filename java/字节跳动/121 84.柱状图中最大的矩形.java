/*
	算法思想：
		从当前位置向左，向左找到左边大于当前高度的最小下标，向右找到右边大于当前高度的最大下标
		
	题解：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/   暴力
	
*/


class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxsize = 0;
        for(int i=0;i<heights.length;i++){
            int cur = heights[i];

            int left = i;
            //找到左边大于当前高度的最小下标
            while(left >0 && heights[left-1] >= cur){
                left--;
            }

            int right = i;
            //找到右边大于当前高度的最大下标
            while(right < heights.length-1 && heights[right+1] >= cur)
                right++;

            int weight = right-left+1;
            maxsize = Math.max(maxsize,weight*cur);
        }
        return maxsize;
    }
}