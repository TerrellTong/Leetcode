/*
	算法思想：
		暴力
*/

class Solution {
    /**
     * 85. 最大矩形 
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int col = matrix.length;
        int row = matrix[0].length;
        int[] heights = new int[row];
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights)); //分别求前一层、两层、三层...最大面积
        }
        return ans;
    }

    /**
     * 84. 柱状图中最大的矩形
     */
   public int largestRectangleArea(int[] heights) {
        int area = 0, len = heights.length;
        for (int i = 0; i < heights.length ; i++) {
            int w = 1, h = heights[i], j = i;
            while ( --j >= 0 && heights[j] >= h) { //找i的左边高度大于h的连续个数,注意边界
                w++;
            }
            j = i ;// 找i的右边高度大于h的连续个数
            while ( ++j < len && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * heights[i]);
        }
        return area;
    }
}

作者：wang-xue-lei-2
链接：https://leetcode-cn.com/problems/maximal-rectangle/solution/5ms-85tong-su-de-bao-li-jie-fa-8485ti-by-v4h0/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。