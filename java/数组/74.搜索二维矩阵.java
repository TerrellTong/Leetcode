/*
	算法思想：
		直接比较最后一行
		

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i=0;
		//找到哪一行比target大，就直接返回
        for(;i<row;i++){
            if(matrix[i][col-1] >= target)
                break;
        }
        
		//防止在没有满足条件就退出了for循环
		//例如[[1]]，2
        if(i == row)
            i = row-1;
		//从退出的那一行开始，再找到想要的
        for(int j=0;j<col;j++){
            if(matrix[i][j] == target)
                return true;
            }
        return false;
        }
    }
