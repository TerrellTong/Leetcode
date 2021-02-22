/*
	算法思想：
		简单题，简单思路
*/


class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        while(i < row-1){
            int j = 0;
            while(j < col-1){
                if(matrix[i][j] != matrix[i+1][j+1])
                    return false;
                j++;
            }
            i++;
        }
        return true;
    }
}