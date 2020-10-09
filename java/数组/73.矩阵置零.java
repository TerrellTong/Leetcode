/*
	算法思想：
		O(1)时间复杂度，不要求使用而外的空间
		
		关键思想: 用matrix第一行和第一列记录该行该列是否有0,作为标志位
		但是对于第一行,和第一列要设置一个标志位,为了防止自己这一行(一列)也有0的情况.注释写在代码里,直接看代码很好理解!

		
题解：https://leetcode-cn.com/problems/set-matrix-zeroes/solution/o1kong-jian-by-powcai/  思路二
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        //第一行是否存在0
        for(int j=0;j<col;j++){
            if(matrix[0][j] == 0){
                row0_flag = true;
                break;
            }
        }
        //第一列是否存在0
        for(int i=0;i<row;i++){
            if(matrix[i][0] == 0){
                col0_flag = true;
                break;
            }
        }

        //从(1,1)开始遍历,如果发现了[i,j]为0，则把[i,0]置为0，[0,j]置为0
        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        
        //如果找到存在[i,0]或者[0,j]为0，则把对应标记的行列元素全部置为0
        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }

        if(row0_flag){
            for(int j=0;j<col;j++)
                matrix[0][j] = 0;
        }

          if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        } 
    }
}