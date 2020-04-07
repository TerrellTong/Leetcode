/*
	算法思想：
		数学规律，对角线翻转然后再根据列的中点进行翻转
				
*/

class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int temp;
        //以对角线为轴进行翻转
        for(int i=0;i<row;i++)
            for(int j=i+1;j<col;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        //将对角线翻转后再次根据列的中点翻转
        //找中点
        int mid = col >>> 1 ;
        for(int i=0;i<row;i++)
            for(int j=0 ;j<mid ;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][col-1-j];
                matrix[i][col-1-j] = temp;
            }
    }
}








