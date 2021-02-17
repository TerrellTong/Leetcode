/*
	算法思想：
		简单题的模拟
*/


class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int res = r * c;
        int row = nums.length;
        int col = nums[0].length;
        if(row * col != res)
            return nums;
        int[][] matrix = new int[r][c];
        //遍历原nums数组
        int m_row = 0;
        int m_col = 0;
        //i,j是指向原数组的指针
        int i = 0;
        int j = 0;
        while(m_row<r){
            m_col = 0;
            while(m_col<c){
                if(j < col)
                    matrix[m_row][m_col++] = nums[i][j++];
                else{
                    i++;
                    j = 0;
                }
            }
            m_row++; 
        }
        return matrix;
    }
}