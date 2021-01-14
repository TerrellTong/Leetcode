/*
	算法思想：
		左对角翻转，中线翻转
*/



class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        //沿着左对角线翻转
        for(int i=0;i<row;i++)
            for(int j=i;j<col;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }

        //沿着中线翻转
        for(int i=0;i<row;i++)
            for(int j=0;j<col/2;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][col-j-1];
                matrix[i][col-j-1] = t;
            }
        
    }
}